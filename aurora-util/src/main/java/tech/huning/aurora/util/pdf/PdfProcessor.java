package tech.huning.aurora.util.pdf;

import tech.huning.aurora.util.pdf.core.MagickPdfLibrary;
import tech.huning.aurora.util.pdf.exception.PdfException;
import tech.huning.aurora.util.pdf.model.PdfParam;
import tech.huning.aurora.util.pdf.model.PdfResult;
import tech.huning.aurora.util.pdf.specs.IPdfLibrary;
import tech.huning.aurora.util.pdf.specs.IPdfProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PdfProcessor implements IPdfProcessor {

    private Logger logger = LoggerFactory.getLogger(PdfProcessor.class);

    private Class<? extends IPdfLibrary> clazz = MagickPdfLibrary.class;

    private PdfProcessor(){}

    public static PdfProcessor getInstance() {
        return PdfProcessorHolder.INSTANCE;
    }

    private static class PdfProcessorHolder {
        private static PdfProcessor INSTANCE = new PdfProcessor();
    }

    @Override
    public IPdfProcessor load(Class<? extends IPdfLibrary> clazz) {
        this.clazz = clazz;
        return this;
    }

    @Override
    public PdfResult getTotalPage(PdfParam param) {
        PdfResult pdfResult = new PdfResult();

        try {
            IPdfLibrary pdfLibrary = this.clazz.newInstance();
            pdfResult.setTotalPage(pdfLibrary.getTotalPage(param.getFilePath()));
            pdfResult.setSucc(true);
        } catch (InstantiationException e) {
            pdfResult.setSucc(false);
            logger.error(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            pdfResult.setSucc(false);
            logger.error(e.getMessage(), e);
        } catch (PdfException e) {
            pdfResult.setSucc(false);
            logger.error(e.getMessage(), e);
        }

        return pdfResult;
    }

    @Override
    public PdfResult convertToImage(PdfParam param) {
        PdfResult pdfResult = new PdfResult();

        try {
            IPdfLibrary pdfLibrary = this.clazz.newInstance();
            pdfResult = pdfLibrary.convert(param);
            pdfResult.setSucc(true);
        } catch (InstantiationException e) {
            pdfResult.setSucc(false);
            logger.error(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            pdfResult.setSucc(false);
            logger.error(e.getMessage(), e);
        } catch (PdfException e) {
            pdfResult.setSucc(false);
            logger.error(e.getMessage(), e);
        }

        return pdfResult;
    }

}

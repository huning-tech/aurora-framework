package tech.huning.aurora.util.pdf.core;

import tech.huning.aurora.util.pdf.exception.PdfException;
import tech.huning.aurora.util.pdf.model.PdfParam;
import tech.huning.aurora.util.pdf.model.PdfResult;
import tech.huning.aurora.util.pdf.specs.IPdfLibrary;

/**
 * SpirePdf处理库
 * https://www.e-iceblue.com/Download/pdf-for-java-free.html
 *
 * <p>更多内容参看<a href="https://huning.tech" target="_blank"><b>胡宁Tech</b></a>
 * @author huning
 */
public class SpirePdfLibrary implements IPdfLibrary {
    @Override
    public PdfResult convert(PdfParam param) throws PdfException {
        return null;
    }

    @Override
    public void cleanFileDir(PdfParam param) throws PdfException {

    }

    @Override
    public String pkgImageFilePath(PdfParam param, int pageNo) throws PdfException {
        return null;
    }

    @Override
    public long getTotalPage(String filePath) throws PdfException {
        return 0;
    }

}

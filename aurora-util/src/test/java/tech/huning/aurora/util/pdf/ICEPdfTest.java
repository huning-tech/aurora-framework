package tech.huning.aurora.util.pdf;

import com.alibaba.fastjson.JSON;
import tech.huning.aurora.util.pdf.common.PdfConstant;
import tech.huning.aurora.util.pdf.core.ICEPdfLibrary;
import tech.huning.aurora.util.pdf.model.PdfParam;
import tech.huning.aurora.util.pdf.model.PdfResult;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class ICEPdfTest {

    private static final Logger logger = LoggerFactory.getLogger(ICEPdfTest.class);

    @Test
    public void testGetTotalPage() {
        PdfParam pdfParam = new PdfParam.Builder()
                .setFilePath("D:\\Tmp\\pdf\\test.pdf")
                .setImagePath("D:\\Tmp\\pdf\\test")
                .setImageName(PdfConstant.EMPTY_STRING)
                .setImageFormat("jpg")
                .setImageNameDelimiter(PdfConstant.EMPTY_STRING)
                .setImageStartPageNo(100000)
                .build();

        PdfResult pdfResult = PdfProcessor.getInstance().load(ICEPdfLibrary.class).getTotalPage(pdfParam);
        System.out.println(JSON.toJSONString(pdfResult));
    }

    @Test
    public void testGetTotalPageConcurrent() {
        CountDownLatch cdl = new CountDownLatch(100);
        long startT = System.currentTimeMillis();
        for(int i = 0; i < 100; i++) {
            calcTotalPage();
            cdl.countDown();
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endT = System.currentTimeMillis();
        logger.info("ICEPdfLibrary - cost:{}", endT - startT);
    }
    private void calcTotalPage() {
        PdfParam pdfParam = new PdfParam.Builder()
                .setFilePath("D:\\Tmp\\pdf\\test.pdf")
                .setImagePath("D:\\Tmp\\pdf\\test")
                .setImageName(PdfConstant.EMPTY_STRING)
                .setImageFormat("jpg")
                .setImageNameDelimiter(PdfConstant.EMPTY_STRING)
                .setImageStartPageNo(100000)
                .build();

        PdfResult pdfResult = PdfProcessor.getInstance().load(ICEPdfLibrary.class).getTotalPage(pdfParam);
        System.out.println(JSON.toJSONString(pdfResult));
    }

    @Test
    public void testConvertPdfToJpg() {
        PdfParam pdfParam = new PdfParam.Builder()
                .setFilePath("D:\\Tmp\\pdf\\test.pdf")
                .setImagePath("D:\\Tmp\\pdf\\test")
                .setImageName(PdfConstant.EMPTY_STRING)
                .setImageFormat("jpg")
                .setImageNameDelimiter(PdfConstant.EMPTY_STRING)
                .setImageStartPageNo(100000)
                .build();

        PdfResult pdfResult = PdfProcessor.getInstance().load(ICEPdfLibrary.class).convertToImage(pdfParam);
        System.out.println(JSON.toJSONString(pdfResult));
    }

}

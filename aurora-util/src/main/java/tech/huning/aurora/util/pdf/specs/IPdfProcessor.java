package tech.huning.aurora.util.pdf.specs;

import tech.huning.aurora.util.pdf.model.PdfParam;
import tech.huning.aurora.util.pdf.model.PdfResult;

public interface IPdfProcessor {

    /**
     * 加载库
     * @param clazz 处理器类
     * @return 处理器
     */
    IPdfProcessor load(Class<? extends IPdfLibrary> clazz);

    /**
     * 获取总页数
     * @param param pdf信息入参
     * @return 读取结果
     */
    PdfResult getTotalPage(PdfParam param);

    /**
     * 转为图片
     * @param param pdf信息入参
     * @return 读取结果
     */
    PdfResult convertToImage(PdfParam param);

}

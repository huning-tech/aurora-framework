package tech.huning.aurora.specs.model.po;

import tech.huning.aurora.specs.model.ExportableModel;

/**
 * 可导出 Persistent Object
 *
 * <p>更多内容参看<a href="https://huning.tech"><b>胡宁Tech</b></a>
 * @author huning
 */
public class ExportablePO extends CommonPO implements ExportableModel {

    protected String path;

    @Override
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}

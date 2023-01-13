package tech.huning.aurora.specs.model.po;

/**
 * 可导出 Persistent Object
 *
 * <p>更多内容参看<a href="https://huning.tech"><b>胡宁Tech</b></a>
 * @author huning
 */
public class ExportablePO extends CommonPO {

    protected String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}

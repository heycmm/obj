package cc.orcl.obj.model;

import lombok.Data;
import org.dromara.easyes.annotation.HighLight;
import org.dromara.easyes.annotation.IndexField;
import org.dromara.easyes.annotation.IndexName;
import org.dromara.easyes.annotation.rely.Analyzer;
import org.dromara.easyes.annotation.rely.FieldType;
import org.dromara.easyes.annotation.rely.HighLightTypeEnum;

import java.util.Date;

/**
 * @author：czx.me 2024/7/28
 */
@Data
@IndexName("cc_my-6e2618wk1z49025_halo_movie")
public class MovieDocument {
    private String id;
    @IndexField(fieldType = FieldType.TEXT,searchAnalyzer = Analyzer.IK_MAX_WORD, analyzer = Analyzer.IK_MAX_WORD)
    @HighLight(mappingField = "highlightName", fragmentSize = -1, preTag = "<em class=\"highlight\">", highLightType = HighLightTypeEnum.PLAIN)
    private String name;
    private String link;
    private String size;
    @IndexField(value = "create_time")
    private Date createTime;
    @HighLight(mappingField = "highlightDescription", fragmentSize = -1, preTag = "<em class=\"highlight\">")
    @IndexField(fieldType = FieldType.TEXT, searchAnalyzer = Analyzer.IK_MAX_WORD, analyzer = Analyzer.IK_MAX_WORD)
    private String description;
    private String photo;
    @IndexField(value = "thumb_photo")
    private String thumbPhoto;
    @IndexField(fieldType = FieldType.TEXT,searchAnalyzer = Analyzer.IK_MAX_WORD, analyzer = Analyzer.IK_MAX_WORD)
    @HighLight(mappingField = "highlightTags", fragmentSize = -1, preTag = "<em class=\"highlight\">")
    private String tags;
    @IndexField(value = "obj_type", fieldType = FieldType.INTEGER)
    private Integer objType;

    @IndexField(value = "content", fieldType = FieldType.TEXT)
    private Integer content;

    /**
     * 高亮返回值被映射的字段
     */
    private String highlightDescription;
    private String highlightName;
    private String highlightTags;
}

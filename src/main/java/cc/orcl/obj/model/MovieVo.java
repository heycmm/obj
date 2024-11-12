package cc.orcl.obj.model;

import lombok.Data;

import java.util.Date;

/**
* 
*/
@Data
public class MovieVo {
    /**
    * 
    */
    private String name;
    /**
    * 
    */
    private String description;
    /**
    * 
    */
    private String link;
    /**
    * 
    */
    private String size;
    /**
    * 
    */
    private String tags;
    /**
    * 
    */
    private Date createTime;
    /**
    * 
    */
    private String photo;
    /**
    * 
    */
    private String thumbPhoto;

//
//    /**
//     * 高亮返回值被映射的字段
//     */
//    private String highlightDescription;
//    private String highlightName;
//    private String highlightTags;
}
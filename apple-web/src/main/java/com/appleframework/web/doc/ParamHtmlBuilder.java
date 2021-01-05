package com.appleframework.web.doc;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author tanghc
 */
public class ParamHtmlBuilder {

    private static final String START_TD = "<td>";
    private static final String END_TD = "</td>";
    private static final String START_TR = "<tr>";
    private static final String END_TR = "</tr>";
    private static final String TRUE = "true";



    public String buildHtml(ApiDocFieldDefinition definition, String nameVersion) {
        StringBuilder html = new StringBuilder();
        html.append(START_TR)
            .append(wrapTD(definition.getName()))
            .append("<td class=\"param-type\">"+definition.getDataType() + END_TD)
            .append(wrapTD(this.getRequireHtml(definition)))
            .append(wrapTD(buildExample(definition, nameVersion, null)))
            .append(wrapTD(definition.getDescription()));
        html.append(END_TR);
        
        return html.toString();
    }

    private String wrapTD(String content) {
        return START_TD + content + END_TD;
    }
    
    protected String buildExample(ApiDocFieldDefinition definition, String nameVersion, ApiDocFieldDefinition parentDefinition) {
        StringBuilder html = new StringBuilder();
        if(CollectionUtils.isNotEmpty(definition.getElements())) {
            html.append("<table parentname=\""+ definition.getName() +"\">")
                .append(START_TR)
                    .append("<th>名称</th>")
                    .append("<th>类型</th>")
                    .append("<th>是否必须</th>")
                    .append("<th>示例值</th>")
                    .append("<th>描述</th>")
                .append(END_TR);
            
            List<ApiDocFieldDefinition> els = definition.getElements();
            for (ApiDocFieldDefinition apiDocFieldDefinition : els) {
                html.append(START_TR)
                    .append(wrapTD(apiDocFieldDefinition.getName()))
                    .append("<td class=\"param-type\">"+apiDocFieldDefinition.getDataType() + END_TD)
                    .append(wrapTD(getRequireHtml(apiDocFieldDefinition)))
                    .append(wrapTD(buildExample(apiDocFieldDefinition, nameVersion, definition)))
                    .append(wrapTD(apiDocFieldDefinition.getDescription()))
                .append(END_TR);
            }
            html.append("</table>");
        }else{
            html.append(buildExampleValue(definition, nameVersion, parentDefinition));
        }
        return html.toString();
    }
    
    private String getRequireHtml(ApiDocFieldDefinition definition) {
        if(TRUE.equals(definition.getRequired())) {
            return "<strong>是</strong>";
        }else{
            return "否";
        }
    }

    protected String buildExampleValue(ApiDocFieldDefinition definition, String nameVersion, ApiDocFieldDefinition parentDefinition) {
        String parentname = (parentDefinition == null ? "" : parentDefinition.getName());
        
        String type = "text";
        if(definition.getDataType().equals(DataType.FILE.getValue())
                || definition.getElementClass() == MultipartFile.class) {
            type = "file";
        }
        String id = nameVersion + "_" + definition.getName();
        StringBuilder sb = new StringBuilder();
        
        sb.append("<input id=\"").append(id).append("\" class=\"param-input\" type=\"")
            .append(type).append("\" name=\"").append(definition.getName()).append("\" value=\"")
            .append(definition.getExample()).append("\" ")
            .append(this.getArrAttr(definition))
            .append(this.getDateEvent(definition))
            .append(" parentname=\"").append(parentname).append("\" ")
            .append(" />")
            .append(this.getAddBtn(definition))
            ;
        return sb.toString();
    }
    
    protected String getArrAttr(ApiDocFieldDefinition definition) {
        if(definition.getDataType().equals(DataType.ARRAY.getValue())) {
            return " arrinput=\"true\" ";
        } else {
            return "";
        }
    }

    protected String getDateEvent(ApiDocFieldDefinition definition) {
        if(definition.getDataType().equals(DataType.DATE.getValue())) {
            return " onClick=\"WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})\"";
        } else if(definition.getDataType().equals(DataType.DATETIME.getValue())) {
            return " onClick=\"WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})\"";
        }else {
            return "";
        }
    }
    
    protected String getAddBtn(ApiDocFieldDefinition definition) {
        if(definition.getDataType().equals(DataType.ARRAY.getValue())) {
            return " <button type=\"button\" title=\"添加一行\" class=\"add-array-btn\">+</button>" 
                    + " <button type=\"button\" title=\"删除一行\" class=\"del-array-btn\">-</button>";
        } else {
            return "";
        }
    }
}

package rc.demo.app.util;

public class HTMLUtil {

    public static final String HTML_LESSER_THAN = "<";
    public static final String HTML_GREATER_THAN = ">";
    public static final String HTML_FORWARDSLASH = "/";

    public static final String HTML_TABLE_ROW = "tr";
    public static final String HTML_TABLE_DATA = "td";

    public static final String HTML_TABLE_ROW_START_TAG = String.format("%s%s%s", HTML_LESSER_THAN, HTML_TABLE_ROW, HTML_GREATER_THAN);
    public static final String HTML_TABLE_ROW_END_TAG = String.format("%s%s%s%s", HTML_LESSER_THAN, HTML_FORWARDSLASH, HTML_TABLE_ROW, HTML_GREATER_THAN);

    public static final String HTML_TABLE_DATA_START_TAG = String.format("%s%s%s", HTML_LESSER_THAN, HTML_TABLE_DATA, HTML_GREATER_THAN);
    public static final String HTML_TABLE_DATA_START_TAG_WITH_ROWSPAN_AND_CLASS = String.format("%s%s rowspan=\"%s\" class=\"%s\"%s", HTML_LESSER_THAN, HTML_TABLE_DATA, "%s", "%s", HTML_GREATER_THAN);
    public static final String HTML_TABLE_DATA_START_TAG_WITH_STYLE = String.format("%s%s style=\"%s;\"%s", HTML_LESSER_THAN, HTML_TABLE_DATA, "%s", HTML_GREATER_THAN);
    public static final String HTML_TABLE_DATA_END_TAG = String.format("%s%s%s%s", HTML_LESSER_THAN, HTML_FORWARDSLASH, HTML_TABLE_DATA, HTML_GREATER_THAN);

    public static final String HTML_INPUT = "input";

    public static final String HTML_INPUT_BUTTON = String.format("%s%s type=\"button\" onclick=\"%s\" value=\"%s\" %s%s",HTML_LESSER_THAN, HTML_INPUT, "%s", "%s" ,HTML_FORWARDSLASH, HTML_GREATER_THAN);

}

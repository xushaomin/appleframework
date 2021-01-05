package com.appleframework.web.util;

import com.alibaba.fastjson.JSON;
import com.appleframework.web.bean.Consts;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * @author tanghc
 */
public class PDFUtil {

    private static final Logger log = LoggerFactory.getLogger(PDFUtil.class);

    private static final String UTF8 = Consts.UTF8;
    private static final Charset CHARSET_UTF8 = Charset.forName(UTF8);

    /**
     * html转pdf
     * @param htmlString html内容
     * @param css css样式内容
     * @param out 输出流
     * @param pdfInfo pdf信息
     */
    public static void htmlToPDF(String htmlString, String css, OutputStream out, PDFInfo pdfInfo) {
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter pdfWriter = PdfWriter.getInstance(document, out);
            document.open();
            if (pdfInfo != null) {
                document.addAuthor(pdfInfo.getAuthor());
                document.addCreator(pdfInfo.getCreator());
                document.addSubject(pdfInfo.getSubject());
                document.addTitle(pdfInfo.getTitle());
            }
            document.addCreationDate();
            XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
            InputStream cssInput = new ByteArrayInputStream(css.getBytes(UTF8));
            InputStream htmlInput = new ByteArrayInputStream(htmlString.getBytes(UTF8));
            worker.parseXHtml(pdfWriter, document, htmlInput, cssInput, CHARSET_UTF8, new AsianFontProvider());
            document.close();
        } catch (Exception e) {
            log.error("html转pdf出错, pdfInfo:{}", pdfInfo == null ? "" : JSON.toJSON(pdfInfo), e);
        }
    }

    public static class PDFInfo {
        private String author;
        private String creator;
        private String subject;
        private String title;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class AsianFontProvider extends XMLWorkerFontProvider {

        @Override
        public Font getFont(final String fontname, final String encoding,
                            final boolean embedded, final float size, final int style,
                            final BaseColor color) {
            try {
                BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
                        BaseFont.NOT_EMBEDDED);
                Font font = new Font(bf, size, style, color);
                font.setColor(color);
                return font;
            } catch (Exception e) {
                log.error("getFont出错", e);
            }
            return super.getFont(fontname, encoding, embedded, size, style, color);
        }
    }
}

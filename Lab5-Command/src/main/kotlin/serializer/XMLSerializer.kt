package serializer

import document.IImage
import document.IParagraph
import org.apache.commons.text.StringEscapeUtils

class XMLSerializer : DocumentSerializer() {
    override val extension: String = "xml"

    private var mTitle = ""
    private var mItems = ""

    override fun onSetTitle(title: String) {
        if (!title.isEmpty()) {
            mTitle = "\n  <title text=\"${title.escapeXML}\" />"
        }
    }

    override fun onInsertParagraph(paragraph: IParagraph) {
        mItems += "\n  <paragraph text=\"${paragraph.text.escapeXML}\" />"
    }

    override fun onInsertImage(image: IImage) {
        mItems += "\n  <image path=\"${image.path.escapeXML}\" width=\"${image.width}\" height=\"${image.height}\" />"
    }

    override fun onSerialize(): ByteArray {
        return """
<?xml version="1.0"?>
<document>$mTitle$mItems
</document>""".trimIndent().toByteArray()
    }

    private val String.escapeXML
        get() = StringEscapeUtils.escapeXml10(this)
}

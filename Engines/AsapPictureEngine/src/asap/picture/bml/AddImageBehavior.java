/*******************************************************************************
 *******************************************************************************/
package asap.picture.bml;

import hmi.xml.XMLFormatting;
import hmi.xml.XMLTokenizer;

import java.io.IOException;
import java.util.HashMap;

/**
 * Adds an image to the canvas on a specified layer
 */
public class AddImageBehavior extends PictureBehaviour
{
    private String filePath;
    private String fileName;
    private float layer;

    @Override
    public boolean satisfiesConstraint(String name, String value)
    {
        if (name.equals("filePath")) return true;
        if (name.equals("fileName")) return true;
        return super.satisfiesConstraint(name, value);
    }

    public AddImageBehavior(String bmlId, XMLTokenizer tokenizer) throws IOException
    {
        super(bmlId);
        readXML(tokenizer);
    }

    @Override
    public StringBuilder appendAttributeString(StringBuilder buf, XMLFormatting fmt)
    {
        appendAttribute(buf, "filePath", filePath.toString());
        appendAttribute(buf, "fileName", fileName.toString());
        appendAttribute(buf, "layer", layer);
        return super.appendAttributeString(buf, fmt);
    }

    @Override
    public void decodeAttributes(HashMap<String, String> attrMap, XMLTokenizer tokenizer)
    {
        filePath = getRequiredAttribute("filePath", attrMap, tokenizer);
        fileName = getRequiredAttribute("fileName", attrMap, tokenizer);
        layer = getRequiredFloatAttribute("layer", attrMap, tokenizer);
        super.decodeAttributes(attrMap, tokenizer);
    }

    /*
     * The XML Stag for XML encoding
     */
    private static final String XMLTAG = "addImage";

    /**
     * The XML Stag for XML encoding -- use this static method when you want to see if a given
     * String equals the xml tag for this class
     */
    public static String xmlTag()
    {
        return XMLTAG;
    }

    /**
     * The XML Stag for XML encoding -- use this method to find out the run-time xml tag of an
     * object
     */
    @Override
    public String getXMLTag()
    {
        return XMLTAG;
    }

    @Override
    public String getStringParameterValue(String name)
    {
        if (name.equals("filePath"))
        {
            return filePath.toString();
        }
        if (name.equals("fileName"))
        {
            return fileName.toString();
        }
        return super.getStringParameterValue(name);
    }

    @Override
    public float getFloatParameterValue(String name)
    {
        if (name.equals("layer"))
        {
            return layer;
        }
        return super.getFloatParameterValue(name);
    }

    @Override
    public boolean specifiesParameter(String name)
    {
        if (name.equals("filePath") || name.equals("fileName") || name.equals("layer"))
        {
            return true;
        }
        return super.specifiesParameter(name);
    }
}

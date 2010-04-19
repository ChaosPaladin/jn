package part_readers;

import com.jds.jn.parser.datatree.NumberValuePart;
import com.jds.jn.parser.datatree.ValuePart;
import com.jds.jn.parser.valuereader.ValueReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.swing.*;
import java.awt.*;

/**
 * @author Gilles Duboscq
 */
public class ColorReader implements ValueReader
{
	public boolean loadReaderFromXML(Node n)
	{
		return true;
	}

	public String read(ValuePart part)
	{
		return part.getHexDump();
	}

	public JComponent readToComponent(ValuePart part)
	{
		if (!(part instanceof NumberValuePart))
		{
			throw new IllegalStateException("A ColorReader must be providen an IntValuePart");
		}
		int color = (int)((NumberValuePart) part).getValueAsInt();
		int r = (color & 0x000000ff); //save red
		color = (color & 0xff00ff00) | ((color & 0x00ff0000) >> 0x10); //swap red and blue
		color = (color & 0xff00ffff) | (r << 0x10);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(color));
		return panel;
	}

	public <T extends Enum<T>> T getEnum(ValuePart part)
	{
		return null;
	}

	public boolean saveReaderToXML(Element element, Document doc)
	{
		return true;
	}

	public boolean supportsEnum()
	{
		return false;
	}

}
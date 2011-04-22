package com.jds.jn.parser.parservalue;

import java.awt.Color;

import javax.swing.ImageIcon;

import com.jds.jn.util.ImageStatic;
import com.jds.nio.buffer.NioBuffer;

/**
 * Author: VISTALL
 * Company: J Develop Station
 * Date:  0:47:43/23.07.2010
 */
public class JUnicodeString implements ParserValue<String>
{
	private static Color _color = new Color(100, 255, 100);

	@Override
	public String getValue(NioBuffer b, Object... arg)
	{
		StringBuffer sb2 = new StringBuffer();
		char ch;
		while ((ch = b.getChar()) != 0)
		{
			sb2.append(ch);
		}
		return sb2.toString();
	}

	@Override
	public ImageIcon getIcon()
	{
		return ImageStatic.PART_NORMAL_STRING;
	}

	@Override
	public Color getColor()
	{
		return _color;
	}

	@Override
	public int length()
	{
		return 0;
	}
}

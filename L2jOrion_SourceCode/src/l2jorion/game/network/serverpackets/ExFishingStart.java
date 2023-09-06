/*
 * L2jOrion Project - www.l2jorion.com 
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 *
 * http://www.gnu.org/copyleft/gpl.html
 */
package l2jorion.game.network.serverpackets;

import l2jorion.game.model.L2Character;
import l2jorion.game.network.PacketServer;

public class ExFishingStart extends PacketServer
{
	private static final String _S__FE_13_EXFISHINGSTART = "[S] FE:13 ExFishingStart";
	private L2Character _activeChar;
	private int _x, _y, _z, _fishType;
	private boolean _isNightLure;
	
	public ExFishingStart(L2Character character, int fishType, int x, int y, int z, boolean isNightLure)
	{
		_activeChar = character;
		_fishType = fishType;
		_x = x;
		_y = y;
		_z = z;
		_isNightLure = isNightLure;
	}
	
	@Override
	protected void writeImpl()
	{
		writeC(0xfe);
		writeH(0x13);
		writeD(_activeChar.getObjectId());
		writeD(_fishType); // fish type
		writeD(_x); // x position
		writeD(_y); // y position
		writeD(_z); // z positio
		writeC(_isNightLure ? 0x01 : 0x00); // night lure
		writeC(0x00); // ??
		writeC(_fishType >= 7 && _fishType <= 9 ? 0x01 : 0x00); // 0 = day lure 1 = night lure
		writeC(0x00);
	}
	
	@Override
	public String getType()
	{
		return _S__FE_13_EXFISHINGSTART;
	}
	
}

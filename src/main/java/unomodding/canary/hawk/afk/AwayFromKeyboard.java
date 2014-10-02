/**
 * This file is part of Hawk, a CanaryMod plugin, licensed under the MIT License (MIT).
 *
 * Copyright (c) UnoModding <https://github.com/UnoModding>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package unomodding.canary.hawk.afk;

import java.util.ArrayList;
import java.util.List;

import net.canarymod.Canary;
import net.canarymod.api.entity.living.humanoid.Player;

public final class AwayFromKeyboard {
	private static List<Player> playerList = new ArrayList<Player>();
	
	public static void setAFK(String playername, boolean set) {
		Player player = Canary.getServer().getPlayer(playername);
		setAFK(player, set);
	}
	
	public static void setAFK(Player player, boolean set) {
		if(set) {
			if(!isAFK(player)) {
				playerList.add(player);
			}
		} else {
			if(playerList.contains(player)) {
				playerList.remove(player);
			}
		}
	}
	
	public static boolean isAFK(String playername) {
		Player player = Canary.getServer().getPlayer(playername);
		return playerList.contains(player);
	}
	
	public static boolean isAFK(Player player) {
		return playerList.contains(player);
	}
	
	public static List<Player> getAfkPlayers() {
		return playerList;
	}
}

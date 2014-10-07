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
package unomodding.canary.hawk.tp;

import java.io.File;

import unomodding.canary.hawk.Hawk;
import net.canarymod.Canary;
import net.canarymod.api.entity.living.humanoid.Player;
import net.visualillusionsent.utils.PropertiesFile;

public final class Teleport {
	private static final File configFile = new File(Hawk.getConfigFolder(), "tp.cfg");
	private static PropertiesFile config = new PropertiesFile(configFile);
	
	public static void loadConfig() {
		config.reload();
	}
	
	public static void saveConfig() {
		config.save();
	}
	
	public static void teleport(String teleport, String teleportTo) {
		teleport(Canary.getServer().getPlayer(teleport), Canary.getServer().getPlayer(teleportTo));
	}
	
	public static void teleport(Player teleport, Player teleportTo) {
		teleport.teleportTo(teleportTo.getLocation());
	}
	
	public static boolean allowsTpRequests(Player playername) {
		return config.getBoolean(playername.getName(), true);
	}
	
	public static boolean allowsTpRequests(String playername) {
		return config.getBoolean(playername, true);
	}
	
	public static void setAllowsTpRequests(Player player, boolean allow) {
		config.setBoolean(player.getName(), allow);
	}
	
	public static void setAllowsTpRequests(String playername, boolean allow) {
		config.setBoolean(playername, allow);
	}
}

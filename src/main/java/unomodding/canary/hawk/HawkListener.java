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
package unomodding.canary.hawk;

import unomodding.canary.hawk.afk.AwayFromKeyboard;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.player.ConnectionHook;
import net.canarymod.hook.player.DisconnectionHook;
import net.canarymod.plugin.PluginListener;

public class HawkListener implements PluginListener {
	@HookHandler
    public void onPlayerJoin(ConnectionHook hook) {
		Player player = hook.getPlayer();
		AwayFromKeyboard.setAFK(player, false);
	}
	
	@HookHandler
    public void onPlayerQuit(DisconnectionHook hook) {
		Player player = hook.getPlayer();
		AwayFromKeyboard.setAFK(player, false);
	}
}
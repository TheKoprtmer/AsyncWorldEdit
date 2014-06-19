/*
 * The MIT License
 *
 * Copyright 2013 SBPrime.
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
package org.primesoft.asyncworldedit.worldedit;

import com.sk89q.worldedit.MaxChangedBlocksException;
import java.util.UUID;
import org.bukkit.ChatColor;
import org.primesoft.asyncworldedit.ConfigProvider;
import org.primesoft.asyncworldedit.PluginMain;
import org.primesoft.asyncworldedit.blockPlacer.BlockPlacer;
import org.primesoft.asyncworldedit.blockPlacer.BlockPlacerJobEntry;

/**
 *
 * @author SBPrime
 */
public abstract class AsyncTask extends BaseTask {

    public AsyncTask(final CancelabeEditSession session, final UUID player,
            final String commandName, BlockPlacer blocksPlacer, BlockPlacerJobEntry job) {
        super(session, player, commandName, blocksPlacer, job);
    }

    @Override
    protected Object doRun() throws MaxChangedBlocksException {
        return task(m_cancelableEditSession);
    }

    @Override
    protected void doPostRun(Object result) {
        if (ConfigProvider.isTalkative()) {
            PluginMain.say(m_player, ChatColor.LIGHT_PURPLE + "Blocks processed: " + ChatColor.WHITE + (Integer)result);
        }
    }

    /**
     * Task to run
     *
     * @param editSession
     * @return
     * @throws MaxChangedBlocksException
     */
    public abstract int task(CancelabeEditSession editSession) throws MaxChangedBlocksException;
}

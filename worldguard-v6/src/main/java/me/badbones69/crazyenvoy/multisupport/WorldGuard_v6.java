package me.badbones69.crazyenvoy.multisupport;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.bukkit.Location;

public class WorldGuard_v6 implements WorldGuardVersion {
    
    @Override
    public boolean inRegion(String regionName, Location loc) {
        ApplicableRegionSet set = WorldGuard.getInstance().getPlatform().getRegionContainer().get(BukkitAdapter.adapt(loc.getWorld())).getApplicableRegions(BlockVector3.at(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ()));
        for (ProtectedRegion region : set) {
            if (regionName.equalsIgnoreCase(region.getId())) {
                return true;
            }
        }
        return false;
    }
    
}
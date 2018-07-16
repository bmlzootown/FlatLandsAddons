package ml.bmlzootown;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import ml.bmlzootown.listeners.*;
import ml.bmlzootown.recipes.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * Created by Brandon on 5/22/2016.
 */
public class FlatLandsAddons extends JavaPlugin {
    public static Plugin pl;
    public static Boolean worldEditSupport;
    public static WorldEditPlugin worldEdit;

    public void onEnable() {
        pl = this;
        setupWorldEdit();

        File dir = new File(pl.getDataFolder(), "/");
        if (!dir.exists()) {
            dir.mkdir();
        }

        File dir2 = new File(pl.getDataFolder(), "/schematics/");
        if (!dir2.exists()) {
            dir2.mkdir();
        }

        File schem = new File(pl.getDataFolder() + "/schematics/", "schematics/nether.schematic");
        if (!schem.exists()) {
            pl.saveResource("schematics/nether.schematic", false);
        }

        Bukkit.addRecipe(BlazePowderRecipe.blazePowderRecipe());
        Bukkit.addRecipe(BlazeRodRecipe.blazeRodRecipe());
        Bukkit.addRecipe(EndStoneRecipe.endStoneRecipe());
        Bukkit.addRecipe(ChorusPlantRecipe.chorusPlantRecipe());
        Bukkit.addRecipe(GhastTearRecipe.ghastTearRecipe());
        Bukkit.addRecipe(ReedRecipe.reedRecipe());

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new BlazePowderSmeltEvent(), this);
        pm.registerEvents(new CraftingEvent(), this);
        pm.registerEvents(new CreateSandEvent(), this);
        pm.registerEvents(new NetherRoomEvent(), this);
        pm.registerEvents(new SpawnerEvent(), this);
        pm.registerEvents(new SpawnCactusEvent(), this);
        pm.registerEvents(new ShearCactusEvent(), this);
        pm.registerEvents(new DropPumpkinEvent(), this);
    }

    public void onDisable() {

    }

    private void setupWorldEdit() {
        Plugin plugin = getServer().getPluginManager().getPlugin("WorldEdit");
        if (plugin == null || !(plugin instanceof WorldEditPlugin))
            return;

        worldEditSupport = true;
        worldEdit = (WorldEditPlugin) plugin;
    }

}

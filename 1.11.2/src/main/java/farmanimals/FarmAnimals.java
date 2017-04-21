package farmanimals;

import farmanimals.handler.SpawnEventHandler;
import farmanimals.init.ModConfigs;
import farmanimals.init.ModEntities;
import farmanimals.init.ModItems;
import farmanimals.item.recipes.ModCrafting;
import farmanimals.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = FarmAnimals.MODID, name = FarmAnimals.NAME, version = FarmAnimals.VERSION)
public class FarmAnimals {
    public static final String MODID = "farmanimals";
    public static final String NAME = "FarmAnimals";
    public static final String VERSION = "V1.1";
    
    @Instance(MODID)
    public static FarmAnimals instance = new FarmAnimals();
    
    @SidedProxy(modId = MODID, serverSide = "farmanimals.proxy.CommonProxy", clientSide = "farmanimals.proxy.ClientProxy")
    public static CommonProxy proxy = new CommonProxy();
    
    public ModConfigs configs;
    public ModItems items;
    public ModCrafting crafting;
    public ModEntities entities;
    
    @EventHandler
    public void init(FMLPreInitializationEvent event) {
    	configs = new ModConfigs();
    	configs.init(event);
    	items = new ModItems();
    	items.init();
    	items.register();
    	crafting = new ModCrafting();
    	crafting.register();
    	entities = new ModEntities();
    	entities.register();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) { 	
    	MinecraftForge.EVENT_BUS.register(new SpawnEventHandler());
    }
    
    @EventHandler
    public void init(FMLPostInitializationEvent event) {
    	proxy.registerModels();
    }
    
}

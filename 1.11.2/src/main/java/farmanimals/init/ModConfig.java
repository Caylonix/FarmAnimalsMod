package farmanimals.init;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ModConfig {
	
    public static int cowMutationRate;
    public static int milkaTransTime;
    public static int wildCowType;
    public static boolean cowExchange;
    
    @EventHandler
    public void init(FMLPreInitializationEvent event) {
    	
    	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
    	
    	config.load();
    	
    	cowMutationRate = config.getInt("Cow", "mutationrate", 10, 0, 2147483647, "Sets the probability for a cow to give birth to a differend cow race. The greater the number, the less probable the mutation");
    	milkaTransTime = config.getInt("MilkaTransTime", "traformationtime", 2000, 0, 2147483647, "How long the 'cow to Milka Cow' transformation prcess will take. 1s = 20");
    	wildCowType = config.getInt("wildCowType", "worldgen", 0, 0, 4, "Determines, which cow race will be spawn naturally. 0 = Vanilla, 1 = Blonde, 2 = Black, 3 = Brown, 4 = Milka");
    	cowExchange = config.getBoolean("ExchangeVanillaCows", "worldgen", true, "If true, exchanges all spawned Vanilla Cows");
    	
    	config.save();
    }
}

package i.gishreloaded.gishcode.hack.hacks;


import i.gishreloaded.gishcode.hack.Hack;
import i.gishreloaded.gishcode.hack.HackCategory;
import i.gishreloaded.gishcode.utils.RayCastUtils;
import i.gishreloaded.gishcode.utils.TimerUtils;
import i.gishreloaded.gishcode.utils.Utils;
import i.gishreloaded.gishcode.utils.ValidUtils;
import i.gishreloaded.gishcode.utils.visual.ChatUtils;
import i.gishreloaded.gishcode.value.Mode;
import i.gishreloaded.gishcode.value.types.BooleanValue;
import i.gishreloaded.gishcode.value.types.DoubleValue;
import i.gishreloaded.gishcode.value.types.IntegerValue;
import i.gishreloaded.gishcode.value.types.ModeValue;
import i.gishreloaded.gishcode.wrappers.Wrapper;
import net.minecraftforge.fml.common.Mod.EventHandler;
 
//TODO
public class Newchunks extends Hack{
    public Newchunks() 
    {
 	   super("NewChunks", HackCategory.VISUAL);
    }
    public String getDescription() {
		return "Show New Chunks.";
	}
    
    public static class ChunkData
    {
        private int x;
        private int z;

        public ChunkData(int x, int z)
        {
            this.x = x;
            this.z = z;
        }

        public int getX()
        {
            return x;
        }

        public void setX(int x)
        {
            this.x = x;
        }

        public int getZ()
        {
            return z;
        }

        public void setZ(int z)
        {
            this.z = z;
        }
    }
}

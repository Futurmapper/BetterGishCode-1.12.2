package i.gishreloaded.gishcode.hack.hacks;

import i.gishreloaded.gishcode.hack.Hack;
import i.gishreloaded.gishcode.hack.HackCategory;
import i.gishreloaded.gishcode.utils.Ananinami;
import i.gishreloaded.gishcode.utils.BlockUtils;
import i.gishreloaded.gishcode.wrappers.Wrapper;
import net.minecraft.block.material.Material;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class Jesus extends Hack 
{
	//TODO : Contunie to make it
	int ticks;
	private int tickTimer;
   public Jesus() 
   {
	   super("Jesus", HackCategory.MOVEMENT);
   }
   public String getDescription() {
		return "Be like jesus !";
	}
   public void onEnable() 
   {
	   ticks = 2;
		super.onEnable();
   }
   public void onDisable() 
   {
	   super.onDisable();
   }
   public void onClientTick(ClientTickEvent event) 
   {
		if(!Wrapper.INSTANCE.player().isInWater() && !Wrapper.INSTANCE.player().isInLava()) 
		{
			return;
		}
	    if(Wrapper.INSTANCE.player().isSneaking() || Wrapper.INSTANCE.mcSettings().keyBindJump.isKeyDown()) 
	    {
			return;
	    }
		if(Wrapper.INSTANCE.player().isInWater()) 
		{
				Wrapper.INSTANCE.player().motionY = 0.11;
				tickTimer = 0;
				return;
		}
		if(tickTimer == 0) {	
				Wrapper.INSTANCE.player().motionY = 0.30;
		}
		else if(tickTimer == 1) {
				Wrapper.INSTANCE.player().motionY = 0;
		}
		tickTimer++;
   }
   
   private boolean isLiquidCollisionEnabled(EntityPlayer player)
	{
		if(player == null)
			return false;
		
		if(player.isSneaking()
			&& GameSettings.isKeyDown(Wrapper.INSTANCE.mc().gameSettings.keyBindSneak))
			return false;
		
		if(player.isInWater() || player.fallDistance > 3)
			return false;
		
		return true;
	}
   private boolean isStandingOnLiquid(EntityPlayer player)
	{
		if(!isLiquidCollisionEnabled(player))
			return false;
		
		World world = Ananinami.getWorld(player);
		boolean foundLiquid = false;
		boolean foundSolid = false;
		
	
		AxisAlignedBB playerBox = player.getEntityBoundingBox();
		playerBox = playerBox.union(playerBox.offset(0, -0.5, 0));
				
		for(AxisAlignedBB box : world.getCollisionBoxes(player, playerBox))
		{
			BlockPos pos = new BlockPos(box.getCenter());
			Material material = BlockUtils.getMaterial(pos);
			
			if(material == Material.WATER || material == Material.LAVA)
				foundLiquid = true;
			else if(material != Material.AIR)
				foundSolid = true;
		}
		
		return foundLiquid && !foundSolid;
	}

	
}

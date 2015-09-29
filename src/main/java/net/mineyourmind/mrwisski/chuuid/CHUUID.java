package net.mineyourmind.mrwisski.chuuid;


import net.kaikk.mc.uuidprovider.UUIDProvider;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import com.laytonsmith.PureUtilities.SimpleVersion;
import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.core.extensions.AbstractExtension;
import com.laytonsmith.core.extensions.MSExtension;

@MSExtension("CHUUID") // Place your extension name here!
public class CHUUID extends AbstractExtension {
	private Plugin plug = null;
	public UUIDProvider uuidprov = null;
	public static CHUUID instance = null;
	public boolean enabled = false;
	
    public Version getVersion() {
        return new SimpleVersion(0,0,1); // Set your version here.
    }
    
    public static void log(String message){
    	System.out.println("[ChUUID] " + message);
    }
    
    @Override
	public void onStartup() {
    	instance = this;
    	this.enabled = false;
 
    	log(getVersion() + " loading.");
    	plug = Bukkit.getPluginManager().getPlugin("UUIDProvider");
    	if(plug == null){
    		log("UUIDProvider plugin not found. Disabling ChUUID functionality.");
    		return;
    	} else {
    		if(plug instanceof UUIDProvider){
    			this.uuidprov = (UUIDProvider)plug;
    			log("Associated with UUIDProvider version " + uuidprov.getDescription().getVersion() + "!");
    			log("ChUUID Enabled.");
    			this.enabled = true;
    		} else {
    			log("Fatal error : Could not locate UUIDProvider plugin. Disabling ChUUID functionality.");
    			return;
    		}
    	}
    	
    	
	}
    
    @Override
    public void onShutdown() {
    	if(this.enabled){
    	   	log(getVersion() + " unloaded!");   		
    	}
 
    }
}
package net.vanillacraft.Factions.main;

import net.vanillacraft.CoreFunctions.main.CoreFunctions;
import net.vanillacraft.Factions.datastore.Faction;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

/**
 * Created by ryan on 5/7/2015.
 */
public class Factions extends JavaPlugin
{

    private HashMap<String, Faction> factionList;
    private HashMap<UUID, Faction> playerFactionList;
    private static Factions instance;
    private CoreFunctions coreFunctions;

    public static JavaPlugin getInstance()
    {
        return instance;
    }

    @Override
    public void onEnable()
    {
        List<String> allyList = new ArrayList<>();
        allyList.add("Worker");
        factionList.put("Red", new Faction("Red", ChatColor.RED, allyList));
        factionList.put("Blue", new Faction("Blue", ChatColor.BLUE, allyList));
        allyList.add("Red");
        allyList.add("Blue");
        factionList.put("Worker", new Faction("Worker", ChatColor.DARK_PURPLE, allyList));

        instance = this;

        coreFunctions = (CoreFunctions) getServer().getPluginManager().getPlugin("CoreFunctions");
    }

    public CoreFunctions getCoreFunctions()
    {
        return coreFunctions;
    }

    @Override
    public void onDisable()
    {

    }

    public void joinFaction(Player player, Faction fac)
    {
        //TODO: make this
    }

    public void leaveFaction(Player player){
        //TODO: make this
    }

    public Faction[] getFactions()
    {
        Faction[] output = new Faction[factionList.size()];
        int i = 0;
        for (Map.Entry<String, Faction> entry : factionList.entrySet())
        {
            output[i] = entry.getValue();
            i += 1;
        }
        return output;
    }

    public Faction getFaction(Player player)
    {
        if (playerFactionList.containsKey(player.getUniqueId()))
        {
            return playerFactionList.get(player.getUniqueId());
        }
        else
        {
            return null;
        }
    }

    public Faction getFaction(String factionName)
    {
        if (factionList.containsKey(factionName))
        {
            return factionList.get(factionName);
        }
        else
        {
            return null;
        }
    }

    public Faction getFaction(Location location)
    {
        //TODO: Need to work with zones plugin.
        return null;
    }

    public void playerEnterNewFaction(Player player, Faction fac)
    {
        player.sendMessage(ChatColor.GREEN + " You've now entered " + ChatColor.WHITE + fac.getName() + ChatColor.GREEN + " zone.");
    }

    public void sendFactionHelp(Player player)
    {
        getCoreFunctions().getCoreErrors().commandSantaxError(player, "faction", "[join] [faction] | this will let you join a faction");
        getCoreFunctions().getCoreErrors().commandSantaxError(player, "faction", "[switch] [faction] | this will let you switch to a faction instantly");
        getCoreFunctions().getCoreErrors().commandSantaxError(player, "faction", "[leave] | this will let you join a faction");
        getCoreFunctions().getCoreErrors().commandSantaxError(player, "faction", "[list] | this will print out a list of factions");
        getCoreFunctions().getCoreErrors().commandSantaxError(player, "faction", "[help] | this will print out this list");
    }

    public void sendFactionHelp(Player player, String arg)
    {
        if (arg.equalsIgnoreCase("all"))
        {
            sendFactionHelp(player);
        }
        else if (arg.equalsIgnoreCase("join"))
        {
            getCoreFunctions().getCoreErrors().commandSantaxError(player, "faction", "[join] [faction] | this will let you join a faction");
        }
        else if (arg.equalsIgnoreCase("switch"))
        {
            getCoreFunctions().getCoreErrors().commandSantaxError(player, "faction", "[switch] [faction] | this will let you switch to a faction instantly");
        }
        else if (arg.equalsIgnoreCase("leave"))
        {
            getCoreFunctions().getCoreErrors().commandSantaxError(player, "faction", "[leave] | this will let you join a faction");
        }
        else if (arg.equalsIgnoreCase("list"))
        {
            getCoreFunctions().getCoreErrors().commandSantaxError(player, "faction", "[list] | this will print out a list of factions");
        }
        else if (arg.equalsIgnoreCase("help"))
        {
            getCoreFunctions().getCoreErrors().commandSantaxError(player, "faction", "[help] | this will tell you how to use the faction command");
        }
    }
}

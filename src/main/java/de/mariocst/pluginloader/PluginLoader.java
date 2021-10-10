package de.mariocst.pluginloader;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.*;

public final class PluginLoader extends JavaPlugin {
    private static String prefix;

    @Override
    public void onEnable() {
        new Prefix();

        Objects.requireNonNull(this.getCommand("plugin")).setExecutor(this);
        Objects.requireNonNull(this.getCommand("plugin")).setTabCompleter(this);

        this.getServer().getLogger().info("Plugin Loader geladen!");
    }

    @Override
    public void onDisable() {
        this.getServer().getLogger().info("Plugin Loader entladen!");
    }

    public static void setPrefix(String newPrefix) {
        prefix = newPrefix;
    }

    private final String[] LOADER = { "load", "unload", "reload" };

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            try {
                if (args.length == 2) {
                    if (args[1].equalsIgnoreCase("PluginLoader")) {
                        sender.sendMessage(prefix + "Du kannst diese Plugin aus technischen Gründen nicht entladen!");
                        return true;
                    }

                    switch (args[0].toLowerCase()) {
                        case "load" -> {
                            File dir = new File("./plugins");
                            File jar = new File(dir, args[1] + ".jar");

                            try {
                                try {
                                    this.getServer().getPluginManager().loadPlugin(jar);
                                    this.getServer().getPluginManager().enablePlugin(Objects.requireNonNull(this.getServer().getPluginManager().getPlugin(args[1])));

                                    sender.sendMessage(prefix + "Plugin " + args[1] + " geladen!");
                                }
                                catch (NullPointerException e) {
                                    sender.sendMessage(prefix + "Konnte Datei nicht finden: " + args[1] + ".jar");
                                }
                            }
                            catch (InvalidPluginException | InvalidDescriptionException e) {
                                sender.sendMessage(prefix + "Das Plugin ist entweder kein Plugin, oder hat eine falsche Beschreibung!");
                            }
                        }
                        case "unload" -> {
                            try {
                                this.getServer().getPluginManager().disablePlugin(Objects.requireNonNull(this.getServer().getPluginManager().getPlugin(args[1])));

                                sender.sendMessage(prefix + "Plugin " + args[1] + " entladen!");
                            }
                            catch (NullPointerException e) {
                                sender.sendMessage(prefix + "Das Plugin " + args[1] + " existiert nicht!");
                            }
                        }
                        case "reload" -> {
                            try {
                                this.getServer().getPluginManager().disablePlugin(Objects.requireNonNull(this.getServer().getPluginManager().getPlugin(args[1])));
                            }
                            catch (NullPointerException e) {
                                sender.sendMessage(prefix + "Das Plugin " + args[1] + " existiert nicht!");
                                return true;
                            }

                            File dir = new File("./plugins");
                            File jar = new File(dir, args[1] + ".jar");

                            try {
                                try {
                                    this.getServer().getPluginManager().loadPlugin(jar);
                                    this.getServer().getPluginManager().enablePlugin(Objects.requireNonNull(this.getServer().getPluginManager().getPlugin(args[1])));
                                }
                                catch (NullPointerException e) {
                                    sender.sendMessage(prefix + "Konnte Datei nicht finden: " + args[1] + ".jar");
                                    return true;
                                }
                            }
                            catch (InvalidPluginException | InvalidDescriptionException e) {
                                sender.sendMessage(prefix + "Das Plugin ist entweder kein Plugin, oder hat eine falsche Beschreibung!");
                                return true;
                            }

                            sender.sendMessage(prefix + "Plugin " + args[1] + " neu geladen!");
                        }
                        default -> sender.sendMessage(prefix + "/plugin <load|unload|reload> <Name>");
                    }
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                sender.sendMessage(prefix + "/plugin <load|unload|reload> <Name>");
            }
            return true;
        }

        if (player.hasPermission("mario.plugin") || player.hasPermission("mario.*") || player.hasPermission("*") || player.isOp()) {
            try {
                if (args.length == 2) {
                    if (args[1].equalsIgnoreCase("PluginLoader")) {
                        sender.sendMessage(prefix + "Du kannst diese Plugin aus technischen Gründen nicht entladen!");
                        return true;
                    }

                    switch (args[0].toLowerCase()) {
                        case "load" -> {
                            File dir = new File("./plugins");
                            File jar = new File(dir, args[1] + ".jar");

                            try {
                                try {
                                    this.getServer().getPluginManager().loadPlugin(jar);
                                    this.getServer().getPluginManager().enablePlugin(Objects.requireNonNull(this.getServer().getPluginManager().getPlugin(args[1])));

                                    sender.sendMessage(prefix + "Plugin " + args[1] + " geladen!");
                                }
                                catch (NullPointerException e) {
                                    sender.sendMessage(prefix + "Konnte Datei nicht finden: " + args[1] + ".jar");
                                }
                            }
                            catch (InvalidPluginException | InvalidDescriptionException e) {
                                sender.sendMessage(prefix + "Das Plugin ist entweder kein Plugin, oder hat eine falsche Beschreibung!");
                            }
                        }
                        case "unload" -> {
                            try {
                                this.getServer().getPluginManager().disablePlugin(Objects.requireNonNull(this.getServer().getPluginManager().getPlugin(args[1])));

                                sender.sendMessage(prefix + "Plugin " + args[1] + " entladen!");
                            }
                            catch (NullPointerException e) {
                                sender.sendMessage(prefix + "Das Plugin " + args[1] + " existiert nicht!");
                            }
                        }
                        case "reload" -> {
                            try {
                                this.getServer().getPluginManager().disablePlugin(Objects.requireNonNull(this.getServer().getPluginManager().getPlugin(args[1])));
                            }
                            catch (NullPointerException e) {
                                sender.sendMessage(prefix + "Das Plugin " + args[1] + " existiert nicht!");
                                return true;
                            }

                            File dir = new File("./plugins");
                            File jar = new File(dir, args[1] + ".jar");

                            try {
                                try {
                                    this.getServer().getPluginManager().loadPlugin(jar);
                                    this.getServer().getPluginManager().enablePlugin(Objects.requireNonNull(this.getServer().getPluginManager().getPlugin(args[1])));
                                }
                                catch (NullPointerException e) {
                                    sender.sendMessage(prefix + "Konnte Datei nicht finden: " + args[1] + ".jar");
                                    return true;
                                }
                            }
                            catch (InvalidPluginException | InvalidDescriptionException e) {
                                sender.sendMessage(prefix + "Das Plugin ist entweder kein Plugin, oder hat eine falsche Beschreibung!");
                                return true;
                            }

                            sender.sendMessage(prefix + "Plugin " + args[1] + " neu geladen!");
                        }
                        default -> sender.sendMessage(prefix + "/plugin <load|unload|reload> <Name>");
                    }
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                player.sendMessage(prefix + "/plugin <load|unload|reload> <Name>");
            }
        }
        else {
            player.sendMessage(prefix + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1f, 1f);
        }
        return false;
    }

    @Override
    public @NotNull List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        final List<String> completions = new ArrayList<>();
        if (args.length == 1) {
            StringUtil.copyPartialMatches(args[0], Arrays.asList(LOADER), completions);
            Collections.sort(completions);
        }
        return completions;
    }
}

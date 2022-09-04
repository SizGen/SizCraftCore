package com.sizcraft.sizcraftcore.command;

import org.bukkit.command.CommandSender;

import java.util.List;

public class TestCommand extends Command {


    public TestCommand() {
        super(
                "test",
                new String[]{"cake","banana"},
                "A test command",
                "test.test"
        );
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        return null;
    }
}

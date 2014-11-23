package me.littlexanman.TheInfected;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class FunctionalBoard {

    private static Scoreboard board;
 
    private ArrayList<Score> score;
 
    private Objective o;
 
    public FunctionalBoard(String string, String string2, String string3, String string5, int sL, String string4, int iL) {
 
    }
 
    @SuppressWarnings("deprecation")
	public FunctionalBoard(String name, String... lines) {
        board = Bukkit.getScoreboardManager().getNewScoreboard();
 
        score = new ArrayList<Score>();
 
        o = board.registerNewObjective("objective", "dummy");
        o.setDisplayName(name);
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
 
        int counter = lines.length;
 
        for (String s : lines) {
            score.add(o.getScore(Bukkit.getOfflinePlayer(s)));
 
            o.getScore(Bukkit.getOfflinePlayer(s)).setScore(counter);
            counter--;
        }
    }
 
    @SuppressWarnings("deprecation")
	public Score getLine(String line) {
        return o.getScore(Bukkit.getOfflinePlayer(line));
    }
 
    @SuppressWarnings("deprecation")
	public void addLine(String... lines) {
 
        for (String s : lines) {
            score.add(o.getScore(Bukkit.getOfflinePlayer(s)));
        }
 
        int counter = score.size();
 
        for (Score s : score) {
            o.getScore(s.getPlayer()).setScore(counter);
            counter--;
        }
    }
 
    public ArrayList<Score> getScores() {
        return score;
    }
 
    public static void setBoard(Player player, FunctionalBoard fb) {
        player.setScoreboard(board);
    }
 
}

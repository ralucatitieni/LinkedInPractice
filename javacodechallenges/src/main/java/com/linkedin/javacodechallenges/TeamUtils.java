package com.linkedin.javacodechallenges;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class TeamUtils {

    public static void generateTeamsScores(List<Team> teams,
            int numberOfRounds) {
        Random random = new Random();
        teams.forEach(team -> {
            for (int i = 0; i < numberOfRounds; i++) {
                team.getScores().add(random.nextInt(11));
            }
        });
    }

    public static void revealResults(List<Team> teams) {
        if (teams == null && teams.isEmpty()) {
            System.out.println("The game hasn't started yet.\n");
        } else {
        Map<Team, Double> winners = teams.stream()
                .collect(Collectors.toMap(team -> team, team -> team.getScores()
                        .stream()
                        .mapToInt(score -> score)
                        .average()
                        .orElseGet(() -> 0.0)));

        winners.entrySet().stream().sorted((a, b) -> b.getValue().intValue() - a.getValue().intValue())
                .forEach(team -> System.out.println(team.getKey() + "    " + team.getValue()));

    }}
}
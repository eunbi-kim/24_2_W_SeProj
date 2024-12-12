package com.jamong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SongRecommendationUI {

    public static void main(String[] args) {
        // UI 구성
        JFrame frame = new JFrame("Jamong - 추천 시스템");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(7, 2));

        // 입력 요소 생성
        JLabel genderLabel = new JLabel("성별:");
        JComboBox<String> genderBox = new JComboBox<>(new String[]{"남", "여"});

        JLabel ageLabel = new JLabel("나이대:");
        JComboBox<String> ageBox = new JComboBox<>(new String[]{"10대", "20대", "30대", "40대", "50대", "60대 이상"});

        JLabel childrenLabel = new JLabel("자녀 수:");
        JComboBox<String> childrenBox = new JComboBox<>(new String[]{"없음", "1명", "2명", "3명", "4명 이상"});

        JLabel deviceLabel = new JLabel("주 사용 기기:");
        JComboBox<String> deviceBox = new JComboBox<>(new String[]{"PC", "노트북", "아이폰", "안드로이드"});

        JLabel countryLabel = new JLabel("선호 국가:");
        JComboBox<String> countryBox = new JComboBox<>(new String[]{"한국", "미국", "중국", "일본", "유럽"});

        JButton submitButton = new JButton("추천받기");
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        // UI에 요소 추가
        frame.add(genderLabel);
        frame.add(genderBox);
        frame.add(ageLabel);
        frame.add(ageBox);
        frame.add(childrenLabel);
        frame.add(childrenBox);
        frame.add(deviceLabel);
        frame.add(deviceBox);
        frame.add(countryLabel);
        frame.add(countryBox);
        frame.add(submitButton);
        frame.add(new JScrollPane(resultArea));

        // 추천 버튼 동작 설정
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gender = (String) genderBox.getSelectedItem();
                String ageGroup = (String) ageBox.getSelectedItem();
                int numberOfChildren = childrenBox.getSelectedIndex();
                String device = (String) deviceBox.getSelectedItem();
                String preferredCountry = (String) countryBox.getSelectedItem();

                // RecommendationEngine 호출
                RecommendationEngine engine = new RecommendationEngine();
                String recommendation = engine.recommend(gender, ageGroup, numberOfChildren, device, preferredCountry);

                // 결과 출력
                resultArea.setText("추천 곡:\n" + recommendation);
            }
        });

        // 창 표시
        frame.setVisible(true);
    }
}

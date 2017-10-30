package lili.tesla.divinations.presentation.screen.divination.view;

/**
 * Created by Лилия on 25.10.2017.
 */

public interface DivinationView {
    void showPredictionScreen();
    void showButtonTossCount(boolean flag);
    void showButtonPredictionScreen(boolean flag);
    void showLine(int randomNum, int orderNum);

}

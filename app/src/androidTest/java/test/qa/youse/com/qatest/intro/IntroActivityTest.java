package test.qa.youse.com.qatest.intro;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import br.com.youse.qa.test.views.intro.IntroActivity;
import test.qa.youse.com.qatest.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Created by ana.silva.dos.santos on 24/09/2018.
 */

@RunWith(AndroidJUnit4.class)
public class IntroActivityTest {


    @Rule
    public ActivityTestRule<IntroActivity>
            mActivityRule = new ActivityTestRule<>(IntroActivity.class, false, true);


        @Test
        public void whenActivityIsLaunched_shouldDisplayHiAndNumberOne() {
            onView(withText("Olá")).check(matches(isDisplayed()));
            onView(withText("1")).check(matches(isDisplayed()));

        }

        @Test
        public void whenActivityIsLaunched_shouldDisplayWelcomeAndNumberTwo(){
        onView(ViewMatchers.withId(R.id.pager)).perform(ViewActions.swipeLeft());
        onView(withText("Bem Vindo!")).check(matches(isDisplayed()));
        onView(withText("2")).check(matches(isDisplayed()));

        }

        @Test
        public void DisplayNumberThree() throws InterruptedException {
            for (int i = 0; i < 2; i++) {
                onView(withId(R.id.pager)).perform(ViewActions.swipeLeft());
            }
            onView(withText("3")).check(matches(isDisplayed()));
        }

}

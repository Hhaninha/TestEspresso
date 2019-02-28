package test.qa.youse.com.qatest.login;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import br.com.youse.qa.test.views.login.LoginActivity;
import test.qa.youse.com.qatest.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by ana.silva.dos.santos on 24/09/2018.
 */

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity>
            mActivityRule = new ActivityTestRule<>(LoginActivity.class, false, true);


    @Test
    public void whenActivityIsLaunched_shouldDisplayInitialState() {
        onView(ViewMatchers.withId(R.id.email)).check(matches(isDisplayed()));
        onView(withId(R.id.nextBtn)).check(matches(isDisplayed()));
    }

    @Test
    public void Login() throws InterruptedException {
        onView(withId(R.id.email)).perform(typeText("youser1@youse.com.br"));
        tapButtonProceed();
        onView(withId(R.id.password)).perform(typeText("12345678"));
        onView(withId(R.id.loginBtn)).perform(click());
        TimeUnit.SECONDS.sleep(5);
        onView(withText("Seja bem vindo, youser1@youse.com.br")).check(matches(isDisplayed()));
    }

    @Test
    public void tapButtonProceed() {
        onView(withId(R.id.nextBtn)).perform(click());
    }

    @Test
    public void validMessageErrorEmail(){
        onView(withId(R.id.nextBtn)).perform(click());
        onView(withText("Email Inválido")).check(matches(isDisplayed()));
    }

    @Test
    public void validMessageErrorPassword(){
        onView(withId(R.id.email)).perform(typeText("youser1@youse.com.br"));
        tapButtonProceed();
        onView(withId(R.id.password)).perform(typeText("789653"));
        onView(withId(R.id.loginBtn)).perform(click());
        onView(withText("Senha Inválida")).check(matches(isDisplayed()));
    }


}

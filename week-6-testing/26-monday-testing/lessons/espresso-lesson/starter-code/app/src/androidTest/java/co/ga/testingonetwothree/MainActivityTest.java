package co.ga.testingonetwothree;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
/**
 * Created by patrickcummins on 7/11/16.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    private String editText1, editText2, answer;

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        editText1 = "100";
        editText2 = "200";
        answer="$300.00";
    }

    @Test
    public void addButton() throws Exception {
        onView(withId(R.id.editText1)).perform(clearText(), typeText(editText1), closeSoftKeyboard());
        onView(withId(R.id.editText2)).perform(clearText(), typeText(editText2), closeSoftKeyboard());

        onView(withId(R.id.addButton)).perform(click());

        onView(withId(R.id.answerTextView)).check(matches(withText(answer)));


    }

    @Test
    public void areTextViewDisplayed() throws Exception {
        onView(withId(R.id.editText1)).check(matches(isDisplayed()));
        onView(withId(R.id.editText2)).check(matches(isDisplayed()));
        onView(withId(R.id.answerTextView)).check(matches(isDisplayed()));
    }

    @Test
    public void checkWrongAdd() throws Exception {
        onView(withId(R.id.editText1)).perform(clearText(), typeText("123"), closeSoftKeyboard());
        onView(withId(R.id.editText2)).perform(clearText(), typeText("456"), closeSoftKeyboard());

        onView(withId(R.id.addButton)).perform(click());

        onView(withId(R.id.answerTextView)).check(matches(withText("789")));
    }
}

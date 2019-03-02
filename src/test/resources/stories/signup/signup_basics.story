Narrative:
This story covers basic tests of signup

Scenario: Type invalid year
Given I open signup page
When I set month "<month>"
And I set day "<day>"
And I set year "<year>"
And I check share
Then I see error "Please enter a valid year."
And I do not see error "When were you born?"
Examples:
|month    |day|year|
|December |15 |85  |
|October  |1  |80  |
|September|5  |90  |

Scenario: Type invalid email
Meta: @skip
Given I open signup page
When I type email "test@mail.test"
And I type confirmation email "wrong@mail.test"
And I type name "Testname"
And I click signup
Then I see error "Email address doesn't match."
And I see error "Not exist"

Scenario: Sign up with empty password
Meta: @skip
Given I open signup page
When I type email "test@mail.test"
And I type confirmation email "test@mail.test"
And I type name "Testname"
And I click signup
Then I see error "Please choose a password."

Scenario: Type invalid values
Meta: @skip
Given I open signup page
When I type email "testmail"
And I type confirmation email "wrong@test.mail"
And I type password "qwerty1234"
And I type name "Name"
And I type sex "Male"
And I uncheck share
And I click signup
Then I see "6" errors
Then I see that "3" error has text "Please enter your birth month."
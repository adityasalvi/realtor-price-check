Feature: PriceCheck

Scenario: Verify Price for Realtor.com Site for Chrome

Given I have navigated to to "www.realtor.com" website using "Chrome" browser

When Realtor.com Site is opened enter "Morgantown, WV" in search Box

When SearchPage is Open VERIFY the search results are greater than zero

Then Get the price and Click on the address of second search results

When Details page is opened VERIFY the price on details page is SAME as search results page

Then Browser is Closed

Scenario: Verify Price for Realtor.com Site in Firefox

Given I have navigated to to "www.realtor.com" website using "Firefox" browser

When Realtor.com Site is opened enter "Morgantown, WV" in search Box

When SearchPage is Open VERIFY the search results are greater than zero

Then Get the price and Click on the address of second search results for Firefox browser

When Details page is opened VERIFY the price on details page is SAME as search results page

Then Browser is Closed
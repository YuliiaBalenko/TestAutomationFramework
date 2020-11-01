Lookup a definition
Narrative:
In order to talk better
As an English student
I want to look up word definitions

Scenario: Looking up the definition of 'apple'
Given the user is on the Wikionary home page
When the user looks up the definition of the word 'apple'
Then they should see the definition 'A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates.'

Scenario: Looking up the definition of '<word>'
Given the user is on the Wikionary home page
When the user looks up the definition of the word:
|word      |
|watermelon|
|papaya    |

Then they should see the definition:
|definition|
|The fruit of the watermelon plant, having a green rind and watery flesh that is typically bright red when ripe and contains black pips.|
|A tropical American evergreen tree, Carica papaya, having large, yellow, edible fruit|

Scenario: Looking up the definition of 'pear'
Meta:
@ignored
Given the user is on the Wikionary home page
When the user looks up the definition of the word 'pear'
Then they should see the definition 'An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem.'

Scenario: Looking up the definition of '<word>'
Given the user is on the Wikionary home page
When the user looks up the definition of the word '<word>'
Then they should see the definition '<definition>'
Examples:
| word   | definition                                                                                         |
| banana | An elongated curved tropical fruit that grows in bunches and has a creamy flesh and a smooth skin. |
| lemon  | A yellowish citrus fruit.                                                                          |


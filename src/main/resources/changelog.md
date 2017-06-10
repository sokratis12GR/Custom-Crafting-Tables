### **CCT 1.3.0**

**Dependencies**:

* Now requires JEI 4.5.0.287 or later

**Features Changed**:

* Small JEI integration improvements

**Bugs Fixed**:

* Unnecessary errors about 1x1 and 2x2 recipes (for jei reports in the log, because they don't really have integration)

* Improved a bit code and performance

### **CCT 1.2.1**

**Dependencies**:

* No longer requires MTLib in order to run

* Added a warning if Forgelin isn't installed

### **CCT 1.2.0**

**Features Added**:

* Added a few config options such as:
    * Added the ability to disable interaction with each table, including the vanilla one via config.
    * Added the ability to color the name of the block while in item form
    * Added the ability to set a stack limit for the tables item forms

* Added German Translation

* Added an update checker

**Bugs Fixed**:

* Added a check for if the arrays in the config are valid and/or replace them with a catcher if they are not.

**Bugs Fixed**:

* A bit of code tweaking here and there to improve performance

### **CCT 1.1.0**

**Features Added**:

* JEI Integration (all tables except 1x1 and 2x2).

**Features Changed**:

* 1x1 Recipes no longer have shaped/shapeless recipes,
 instead just use `mods.cct.OneByOne.addRecipe`.

**Bugs Fixed**:

* Some crafting tables being completely wrong with recipes.

* Some Crashes.

* Some Bugs causing things to not work.

### **CCT 1.0.0**

**Features Added**:

* 1->10x1->10 Benches

* CraftTweaker/MineTweaker Integration/Support

* A few config options for names (block/item names and GUI display name)

**Coming Soon**:

* Just Enough Items (JEI) integration

* And more
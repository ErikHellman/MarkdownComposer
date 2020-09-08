package se.hellsoft.markdowncomposer

import org.intellij.lang.annotations.Language

@Language("Markdown")
const val MIXED_MD = """
### Markdown Header

This is regular text without formatting in a single paragraph.

![Serious](file:///android_asset/serios.jpg)

Images can also be inline: ![Serious](file:///android_asset/serios.jpg). [Links](http://hellsoft.se) and `inline code` also work. This *is* text __with__ inline styles for *__bold and italic__*. Those can be nested.

Here is a code block:
```javascript
function codeBlock() {
    return true;
}
```

+ Bullet
+ __Lists__
+ Are
+ *Cool*

1. **First**
1. *Second*
1. Third
1. [Fourth is clickable](https://google.com)  
   1. And
   1. Sublists
1. Mixed
   - With
   - Bullet
   - Lists

100) Lists
100) Can
100) Have
100) *Custom*
100) __Start__
100) Numbers

- List
- Of
- Items
  - With
  - Sublist

> A blockquote is useful for quotes!

"""

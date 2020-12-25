Custom emoji-java

Source code is custom from https://github.com/vdurmont/emoji-java

What I did are:
- In DataGeneration module, I generate a custom emojis.json data from noto color emoji image file name to be compatible with noto color emoji font.
- Images are downloaded from https://www.google.com/get/noto/help/emoji/
- These images can also be used to draw emoji from text.
- Skip the supports for Fitzpatrick or Gender from original sources. We check the unicode code points of emojis directly.
- Skip all the original test since they are no longer correct.
- I remove \ufe0f from the equation. I will remove all \ufe0f from text before use this to check.

To update lib with new emoji:
1. Add new emoji image with same format name as other exist image.
2. Run DataGeneration module to update emojis.json.
3. Replace \\\\u by \u in the file.
4. Run mvn clean package.

Those functions relative to tag, Fitzpatrick, aliases are supposed to not work.
I create this for use of the extract emoji function only.

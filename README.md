# LeetCode

毕业了

IDEA过期了

Java也不写了

🙄

~~Idea 有LeetCode插件能一键生成~~

~~[leetcode-editor/README_ZH.md at master · shuzijun/leetcode-editor](https://github.com/shuzijun/leetcode-editor/blob/master/README_ZH.md)~~

~~文件名模板~~

```
Q$!{question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug})
```

~~生成代码模板~~

```
${question.content}
package editor.cn;
//Java：${question.title}
public class Q$!{question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug}) {
    public static void main(String[] args) {
        Solution solution = new Q$!{question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
        // test
    }
    
${question.code}
}
```


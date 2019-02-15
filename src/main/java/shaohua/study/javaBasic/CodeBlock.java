package shaohua.study.javaBasic;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/07/19 15:54
 */
public class CodeBlock {
    int b;
    static int a = 0;
    static CodeBlock cb = new CodeBlock();
    {
        b = a;
    }
    static{
        //++a;
        cb.b = a++;
    }

    CodeBlock(){
        ++a;
    }
    public static void main(String[] args) {
        CodeBlock codeBlock = new CodeBlock();
        System.out.println(codeBlock.a);
        System.out.println(codeBlock.cb.a);
        System.out.println(codeBlock.b);
        System.out.println(codeBlock.cb.b);
    }
}

//static 按顺序执行 new 对象会执行{}

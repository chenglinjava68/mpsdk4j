package io.github.elkan1788.mpsdk4j.vo.message;

import java.util.List;
import java.util.Map;

import org.nutz.lang.Lang;

/**
 * 多图文消息
 * 
 * @author 凡梦星尘(elkan1788@gmail.com)
 * @since 2.0
 */
public class NewsMsg extends BaseMsg {

    /**
     * 图文消息个数,限制为10条以内
     */
    private int count;
    /**
     * 多条图文消息信息,默认第一个item为大图,
     * </p>
     * 注意:如果图文数超过10,则将会无响应
     */
    private List<Article> articles;

    public NewsMsg() {
        super();
    }

    public NewsMsg(Map<String, String> values) {
        super(values);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Article> getArticles() {
        if (!Lang.isEmpty(articles) && articles.size() > 10) {
            this.articles = articles.subList(0, 10);
            setCount(10);
        }
        else {
            this.setCount(Lang.length(articles));
        }
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "NewsMsg [toUserName="
               + toUserName
               + ", fromUserName="
               + fromUserName
               + ", createTime="
               + createTime
               + ", msgType="
               + msgType
               + ", msgId="
               + msgId
               + ", count="
               + count
               + ", articles="
               + articles
               + "]";
    }
}

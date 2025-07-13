package com.kg;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static com.kg.utils.RandomTimeGeneratorUtils.generateRandomDateTime;

@Slf4j
@MapperScan("com.kg.mapper")
@SpringBootApplication
public class Application {
    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(Application.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String context = env.getProperty("server.servlet.context-path");
        log.info("\n----------------------------------------------------------\n\t" +
                "Application Jeecg-Boot is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + context + "/\n\t" +
                "External: \thttp://" + ip + ":" + port + context + "/\n\t" +
                "Swagger文档: \thttp://" + ip + ":" + port + context + "/doc.html\n" +
                "----------------------------------------------------------");
        System.err.println("generateRandomDateTime:"+generateRandomDateTime(1));
    }
    //将本体模型和三元组数据进行融合
//
//    public static void main(String[] args) throws IOException {
//        // 读取本体模型文件
//        String ontoFileName = "C:/Users/Admin/Desktop/记录/project/社会治理/本体模型/知识图谱构建/d2rq-0.8.1/lanjie_test6.ttl";
//        Model ontoModel = ModelFactory.createDefaultModel();
//        try (InputStream in = new FileInputStream(new File(ontoFileName))) {
//            ontoModel.read(in, null, "TURTLE");
//        }
//
//
//        // 读取数据文件
//        String dataFileName = "C:/Users/Admin/Desktop/记录/project/社会治理/本体模型/知识图谱构建/d2rq-0.8.1/lanjie_test6.nt";
//        Model dataModel = ModelFactory.createDefaultModel();
//        try (InputStream in = new FileInputStream(new File(dataFileName))) {
//            dataModel.read(in, null, "N-TRIPLES");
//        }
//
//        // 合并两个模型
//        ontoModel.add(dataModel);
//
//        // 将合并后的模型写入新文件
//        String outputFileName = "kg_map6.ttl";
//        try (OutputStream out = new FileOutputStream(new File(outputFileName))) {
//            ontoModel.write(out, "TURTLE");
//        }
//    }



//    //推理demo
//    //建立推理机制 {实体隐患，存在风险，风险} ----->{风险，可能产生于,实体隐患}
//    public static void main(String[] args) throws IOException {
//// 加载合并后的模型文件
//        String mergedFileName = "kg_map6.ttl";
//        Model mergedModel = ModelFactory.createDefaultModel();
//        try (InputStream in = new FileInputStream(new File(mergedFileName))) {
//            mergedModel.read(in, null, "TURTLE");
//        }
//
//
//        //1.1直接传规则
//        //
////        String rules = "@prefix vocab: <file:///C:/Users/Admin/Desktop/记录/project/社会治理/本体模型/知识图谱构建/d2rq-0.8.1/vocab/> .\n" +
////                "[ruleInverseOf: " +
////                "(?p vocab:existrists ?m) " +
////                "-> " +
////                "(?m vocab:mayproducefrom ?p)]";
////        Reasoner reasoner = new GenericRuleReasoner(Rule.parseRules(rules));
////        reasoner.setDerivationLogging(true);
////        1.2引用规则文件
//        // 加载规则文件
//        String rulesFile = "rules.rules";
//
//// 创建推理引擎并加载规则文件
//        Reasoner reasoner = new GenericRuleReasoner(Rule.rulesFromURL(rulesFile));
//        reasoner.setDerivationLogging(true);
////        //2.不传规则
////        List<Rule> rules = new ArrayList<>();
////        Reasoner reasoner = new GenericRuleReasoner(rules);
//
//
//        InfModel infModel = ModelFactory.createInfModel(reasoner, mergedModel);
//// 应用规则推理
//        infModel.prepare();
//// 查询推理结果(sparql查询)
////        String queryString = "SELECT ?source " +
////                "WHERE { ?source :hasentities?target . " +
////                "?target rdfs:receptor '广告牌' . " +
////                "?source :hashazards?target . " +
////                "?target rdfs:name '广告牌夜间光线太亮'.";
////        ------------------------------------------------------------------------查询部分-----------------------------------------------------------
//        String queryString=HAZARDS_MAY_RESULT_IN;
////        //1.以表格返回结果
////        Query query = QueryFactory.create(queryString);
////        QueryExecution qexec = QueryExecutionFactory.create(query, infModel);
////        ResultSet results = qexec.execSelect();
////        ResultSetFormatter.out(System.out, results);
////        qexec.close();
//        //2.以三元组返回结果
//        Query query = QueryFactory.create(queryString);
//        QueryExecution qexec = QueryExecutionFactory.create(query, infModel);
//        ResultSet results = qexec.execSelect();
//        while (results.hasNext()) {
//            QuerySolution soln = results.nextSolution();
////            ---------------------------------------------------------------变化部分：填输出---------------------------------------------------------------
////            展示： a 风险 b 实体隐患 c 实体隐患id d 隐患名 e 实体名
////            printInfo(soln, new String[]{"a", "b", "c", "d", "e"}, new String[]{"风险", "实体隐患", "实体隐患id", "实体隐患的隐患名", "实体隐患的实体名"});
////            展示：a 隐患节点 b 风险节点 c风险名
////            printInfo(soln, new String[]{"a", "b", "c"}, new String[]{"隐患节点", "风险节点", "风险名"});
////            展示： a 风险节点 b后果节点 c后果描述
////            printInfo(soln, new String[]{"a", "b", "c"}, new String[]{"风险节点", "后果节点", "后果描述"});
////            展示：展示：a 隐患节点 b后果节点 c后果描述 d 隐患名
//            printInfo(soln, new String[]{"a", "b", "c", "d"}, new String[]{"隐患节点", "b后果节点", "c后果描述", "隐患名"});
//        }
//        qexec.close();
//    }




////输出信息函数
//public static void printInfo(QuerySolution soln, String[] varNames1, String[] varNames2) {
//    char var = 'a';
//
//    for (int i = 0; i < varNames1.length; i++) {
//        RDFNode value = soln.get(varNames1[i]);
//        System.out.println(varNames2[i]  + ": " + value);
//        var++;
//    }
//}












    //结束反括号
}






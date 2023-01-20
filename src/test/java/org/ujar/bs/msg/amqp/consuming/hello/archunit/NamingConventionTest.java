package org.ujar.bs.msg.amqp.consuming.hello.archunit;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.context.annotation.Configuration;

@AnalyzeClasses(packages = "org.ujar.bs.msg.amqp.consuming.hello")
public class NamingConventionTest {
  @ArchTest
  private final ArchRule configurationShouldBeInConfigPackage =
      classes()
          .that().haveSimpleNameContaining("Config")
          .or().areAnnotatedWith(Configuration.class)
          .should().resideInAPackage("..config..");
}

# AT&T XACML

AT&amp;T's reference implementation of the OASIS XACML 3.0 Standard. The AT&T framework represents the entire XACML 3.0 object set as a collection of Java interfaces and standard implementations of those interfaces.  The AT&T PDP engine is built on top of this framework and represents a complete implementation of a XACML 3.0 PDP, including all of the multi-decision profiles. In addition, the framework also contains an implementation of the OASIS XACML 3.0 RESTful API v1.0 and XACML JSON Profile v1.0 WD 14. The PEP API includes annotation functionality, allowing application developers to simply annotate a Java class to provide attributes for a request. The annotation support removes the need for application developers to learn much of the API.

The AT&T framework also includes interfaces and implementations to standardize development of PIP engines that are used by the AT&T PDP implementation, and can be used by other implementations built on top of the AT&T framework. The framework also includes interfaces and implementations for a PAP distributed cloud infrastructure of PDP nodes that includes support for policy distribution and pip configurations. This PAP infrastructure includes a web application administrative console that contains a XACML 3.0 policy editor, attribute dictionary support, and management of PDP RESTful node instances. In addition, there are tools available for policy simulation.

The [wiki] (https://github.com/att/XACML/wiki) has a lot of information on the organization of the software. 

Click here to view the [JavaDoc] (http://att.github.io/XACML/javadocs/index.html).

Tutorials and other useful information is also located on our [Github Pages site] (http://att.github.io/XACML).

# Building the source code

The AT&T Laboratories development team uses Eclipse to build the software. Simply import each project into an Eclipse workspace.

# Requirements

* Java JDK 1.7, you will need to ensure Eclipse has that JDK installed in your development environment.

*  Apache Ivy to bring external dependencies into the build environment. You will need to install the Apache IvyDE Eclipse plug-in for these dependencies to be resolved.


# Milestones

6/10/2014 - Initial Project loaded into Github.


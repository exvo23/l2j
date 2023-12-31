/**
 * Copyright (c) 2004-2011 QOS.ch
 * All rights reserved.
 *
 * Permission is hereby granted, free  of charge, to any person obtaining
 * a  copy  of this  software  and  associated  documentation files  (the
 * "Software"), to  deal in  the Software without  restriction, including
 * without limitation  the rights to  use, copy, modify,  merge, publish,
 * distribute,  sublicense, and/or sell  copies of  the Software,  and to
 * permit persons to whom the Software  is furnished to do so, subject to
 * the following conditions:
 *
 * The  above  copyright  notice  and  this permission  notice  shall  be
 * included in all copies or substantial portions of the Software.
 *
 * THE  SOFTWARE IS  PROVIDED  "AS  IS", WITHOUT  WARRANTY  OF ANY  KIND,
 * EXPRESS OR  IMPLIED, INCLUDING  BUT NOT LIMITED  TO THE  WARRANTIES OF
 * MERCHANTABILITY,    FITNESS    FOR    A   PARTICULAR    PURPOSE    AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE,  ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */
package l2jorion.logger.impl;

import l2jorion.logger.ILoggerFactory;
import l2jorion.logger.spi.LoggerFactoryBinder;

public class StaticLoggerBinder implements LoggerFactoryBinder
{
	private static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();
	
	/**
	 * Return the singleton of this class.
	 * @return the StaticLoggerBinder singleton
	 */
	public static final StaticLoggerBinder getSingleton()
	{
		return SINGLETON;
	}
	
	/**
	 * Declare the version of the SLF4J API this implementation is compiled against. The value of this field is modified with each major release.
	 */
	// to avoid constant folding by the compiler, this field must *not* be final
	public static String REQUESTED_API_VERSION = "1.6.99"; // !final
	
	private static final String loggerFactoryClassStr = l2jorion.logger.impl.JDK14LoggerFactory.class.getName();
	
	/**
	 * The ILoggerFactory instance returned by the {@link #getLoggerFactory} method should always be the same object
	 */
	private final ILoggerFactory loggerFactory;
	
	private StaticLoggerBinder()
	{
		// Note: JCL gets substituted at build time by an appropriate Ant task
		loggerFactory = new l2jorion.logger.impl.JDK14LoggerFactory();
	}
	
	@Override
	public ILoggerFactory getLoggerFactory()
	{
		return loggerFactory;
	}
	
	@Override
	public String getLoggerFactoryClassStr()
	{
		return loggerFactoryClassStr;
	}
}

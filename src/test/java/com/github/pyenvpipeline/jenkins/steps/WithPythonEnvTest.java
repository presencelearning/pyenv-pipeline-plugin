/*
 * The MIT License
 *
 * Copyright 2017 Colin Starner.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 */

package com.github.pyenvpipeline.jenkins.steps;

import org.junit.Assert;
import org.junit.Test;

public class WithPythonEnvTest {

    @Test
    public void testGetBaseDirectory() {
        WithPythonEnvStep windowsStep = new WithPythonEnvStep("C:\\Foo\\Bar\\python3");
        Assert.assertEquals(".pyenv-Foo-Bar-python3", windowsStep.getRelativePythonEnvDirectory());

        WithPythonEnvStep unixStep = new WithPythonEnvStep("/foo/bar/blah/python");
        Assert.assertEquals(".pyenv-foo-bar-blah-python", unixStep.getRelativePythonEnvDirectory());

        unixStep = new WithPythonEnvStep("foo/bar/blah/python");
        Assert.assertEquals(".pyenv-foo-bar-blah-python", unixStep.getRelativePythonEnvDirectory());

        WithPythonEnvStep rawStep = new WithPythonEnvStep("python3");
        Assert.assertEquals(".pyenv-python3", rawStep.getRelativePythonEnvDirectory());
    }

}

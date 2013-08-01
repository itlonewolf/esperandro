package de.devland.esperandro.processor;/*
 * Copyright 2013 David Kunzler
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.tools.Diagnostic;

public class Warner {

    ProcessingEnvironment processingEnv;

    public Warner(ProcessingEnvironment processingEnv) {
        this.processingEnv = processingEnv;
    }

    public void emitWarning(String message, Element element) {
        processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING, message, element);
    }

    public void emitMissingDefaultWarning(String type, ExecutableElement method) {
        processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING, "No overwritten default " + type + " value " +
                "detected, please check the annotation.", method);
    }
}

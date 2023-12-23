package com.gyub.kkangtongdummy.secondware.di

import javax.inject.Qualifier

/**
 * 코루틴 Dispatcher 의존성 Annotation 식별자
 *
 * @author   Gyul
 * @created  2023/12/23
 */
@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class DefaultDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IoDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class MainDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class MainImmediateDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class ApplicationScope

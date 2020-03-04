/*      */ package org.testng;
/*      */ 
/*      */ import java.lang.reflect.Array;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import org.testng.collections.Lists;
/*      */ import org.testng.internal.EclipseInterface;
/*      */ 
/*      */ public class Assert {
/*      */   public static void assertTrue(boolean paramBoolean, String paramString) {
/*   40 */     if (!paramBoolean)
/*   41 */       failNotEquals(Boolean.valueOf(paramBoolean), Boolean.TRUE, paramString); 
/*      */   }
/*      */   
/*      */   public static void assertTrue(boolean paramBoolean) {
/*   51 */     assertTrue(paramBoolean, null);
/*      */   }
/*      */   
/*      */   public static void assertFalse(boolean paramBoolean, String paramString) {
/*   61 */     if (paramBoolean)
/*   62 */       failNotEquals(Boolean.valueOf(paramBoolean), Boolean.FALSE, paramString); 
/*      */   }
/*      */   
/*      */   public static void assertFalse(boolean paramBoolean) {
/*   72 */     assertFalse(paramBoolean, null);
/*      */   }
/*      */   
/*      */   public static void fail(String paramString, Throwable paramThrowable) {
/*   82 */     AssertionError assertionError = new AssertionError(paramString);
/*   83 */     assertionError.initCause(paramThrowable);
/*   85 */     throw assertionError;
/*      */   }
/*      */   
/*      */   public static void fail(String paramString) {
/*   93 */     throw new AssertionError(paramString);
/*      */   }
/*      */   
/*      */   public static void fail() {
/*  100 */     fail(null);
/*      */   }
/*      */   
/*      */   public static void assertEquals(Object paramObject1, Object paramObject2, String paramString) {
/*  111 */     if (paramObject2 != null && paramObject2.getClass().isArray()) {
/*  112 */       assertArrayEquals(paramObject1, paramObject2, paramString);
/*      */       return;
/*      */     } 
/*  115 */     assertEqualsImpl(paramObject1, paramObject2, paramString);
/*      */   }
/*      */   
/*      */   private static void assertEqualsImpl(Object paramObject1, Object paramObject2, String paramString) {
/*  125 */     if (paramObject2 == null && paramObject1 == null)
/*      */       return; 
/*  128 */     if ((((paramObject2 == null) ? 1 : 0) ^ ((paramObject1 == null) ? 1 : 0)) != 0)
/*  129 */       failNotEquals(paramObject1, paramObject2, paramString); 
/*  131 */     if (paramObject2.equals(paramObject1) && paramObject1.equals(paramObject2))
/*      */       return; 
/*  134 */     failNotEquals(paramObject1, paramObject2, paramString);
/*      */   }
/*      */   
/*      */   private static void assertArrayEquals(Object paramObject1, Object paramObject2, String paramString) {
/*  138 */     if (paramObject2 == paramObject1)
/*      */       return; 
/*  141 */     if (null == paramObject2)
/*  142 */       fail("expected a null array, but not null found. " + paramString); 
/*  144 */     if (null == paramObject1)
/*  145 */       fail("expected not null array, but null found. " + paramString); 
/*  148 */     if (paramObject1.getClass().isArray()) {
/*  149 */       int i = Array.getLength(paramObject2);
/*  150 */       if (i == Array.getLength(paramObject1)) {
/*  151 */         for (byte b = 0; b < i; b++) {
/*  152 */           Object object1 = Array.get(paramObject1, b);
/*  153 */           Object object2 = Array.get(paramObject2, b);
/*      */           try {
/*  155 */             assertEquals(object1, object2);
/*  156 */           } catch (AssertionError assertionError) {
/*  157 */             failNotEquals(paramObject1, paramObject2, (paramString == null) ? "" : (paramString + " (values at index " + b + " are not the same)"));
/*      */           } 
/*      */         } 
/*      */         return;
/*      */       } 
/*  164 */       failNotEquals(Integer.valueOf(Array.getLength(paramObject1)), Integer.valueOf(i), (paramString == null) ? "" : (paramString + " (Array lengths are not the same)"));
/*      */     } 
/*  168 */     failNotEquals(paramObject1, paramObject2, paramString);
/*      */   }
/*      */   
/*      */   public static void assertEquals(Object paramObject1, Object paramObject2) {
/*  178 */     assertEquals(paramObject1, paramObject2, (String)null);
/*      */   }
/*      */   
/*      */   public static void assertEquals(String paramString1, String paramString2, String paramString3) {
/*  189 */     assertEquals(paramString1, paramString2, paramString3);
/*      */   }
/*      */   
/*      */   public static void assertEquals(String paramString1, String paramString2) {
/*  199 */     assertEquals(paramString1, paramString2, (String)null);
/*      */   }
/*      */   
/*      */   public static void assertEquals(double paramDouble1, double paramDouble2, double paramDouble3, String paramString) {
/*  214 */     if (Double.isInfinite(paramDouble2)) {
/*  215 */       if (paramDouble2 != paramDouble1)
/*  216 */         failNotEquals(Double.valueOf(paramDouble1), Double.valueOf(paramDouble2), paramString); 
/*  219 */     } else if (Double.isNaN(paramDouble2)) {
/*  220 */       if (!Double.isNaN(paramDouble1))
/*  221 */         failNotEquals(Double.valueOf(paramDouble1), Double.valueOf(paramDouble2), paramString); 
/*  224 */     } else if (Math.abs(paramDouble2 - paramDouble1) > paramDouble3) {
/*  225 */       failNotEquals(Double.valueOf(paramDouble1), Double.valueOf(paramDouble2), paramString);
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void assertEquals(double paramDouble1, double paramDouble2, double paramDouble3) {
/*  238 */     assertEquals(paramDouble1, paramDouble2, paramDouble3, (String)null);
/*      */   }
/*      */   
/*      */   public static void assertEquals(float paramFloat1, float paramFloat2, float paramFloat3, String paramString) {
/*  253 */     if (Float.isInfinite(paramFloat2)) {
/*  254 */       if (paramFloat2 != paramFloat1)
/*  255 */         failNotEquals(Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), paramString); 
/*  258 */     } else if (Math.abs(paramFloat2 - paramFloat1) > paramFloat3) {
/*  259 */       failNotEquals(Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), paramString);
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void assertEquals(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  272 */     assertEquals(paramFloat1, paramFloat2, paramFloat3, (String)null);
/*      */   }
/*      */   
/*      */   public static void assertEquals(long paramLong1, long paramLong2, String paramString) {
/*  283 */     assertEquals(Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString);
/*      */   }
/*      */   
/*      */   public static void assertEquals(long paramLong1, long paramLong2) {
/*  293 */     assertEquals(paramLong1, paramLong2, (String)null);
/*      */   }
/*      */   
/*      */   public static void assertEquals(boolean paramBoolean1, boolean paramBoolean2, String paramString) {
/*  304 */     assertEquals(Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString);
/*      */   }
/*      */   
/*      */   public static void assertEquals(boolean paramBoolean1, boolean paramBoolean2) {
/*  314 */     assertEquals(paramBoolean1, paramBoolean2, (String)null);
/*      */   }
/*      */   
/*      */   public static void assertEquals(byte paramByte1, byte paramByte2, String paramString) {
/*  325 */     assertEquals(Byte.valueOf(paramByte1), Byte.valueOf(paramByte2), paramString);
/*      */   }
/*      */   
/*      */   public static void assertEquals(byte paramByte1, byte paramByte2) {
/*  335 */     assertEquals(paramByte1, paramByte2, (String)null);
/*      */   }
/*      */   
/*      */   public static void assertEquals(char paramChar1, char paramChar2, String paramString) {
/*  346 */     assertEquals(Character.valueOf(paramChar1), Character.valueOf(paramChar2), paramString);
/*      */   }
/*      */   
/*      */   public static void assertEquals(char paramChar1, char paramChar2) {
/*  356 */     assertEquals(paramChar1, paramChar2, (String)null);
/*      */   }
/*      */   
/*      */   public static void assertEquals(short paramShort1, short paramShort2, String paramString) {
/*  367 */     assertEquals(Short.valueOf(paramShort1), Short.valueOf(paramShort2), paramString);
/*      */   }
/*      */   
/*      */   public static void assertEquals(short paramShort1, short paramShort2) {
/*  377 */     assertEquals(paramShort1, paramShort2, (String)null);
/*      */   }
/*      */   
/*      */   public static void assertEquals(int paramInt1, int paramInt2, String paramString) {
/*  388 */     assertEquals(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString);
/*      */   }
/*      */   
/*      */   public static void assertEquals(int paramInt1, int paramInt2) {
/*  398 */     assertEquals(paramInt1, paramInt2, (String)null);
/*      */   }
/*      */   
/*      */   public static void assertNotNull(Object paramObject) {
/*  407 */     assertNotNull(paramObject, null);
/*      */   }
/*      */   
/*      */   public static void assertNotNull(Object paramObject, String paramString) {
/*  417 */     if (paramObject == null) {
/*  418 */       String str = "";
/*  419 */       if (paramString != null)
/*  420 */         str = paramString + " "; 
/*  422 */       fail(str + "expected object to not be null");
/*      */     } 
/*  424 */     assertTrue((paramObject != null), paramString);
/*      */   }
/*      */   
/*      */   public static void assertNull(Object paramObject) {
/*  433 */     assertNull(paramObject, null);
/*      */   }
/*      */   
/*      */   public static void assertNull(Object paramObject, String paramString) {
/*  443 */     if (paramObject != null)
/*  444 */       failNotSame(paramObject, null, paramString); 
/*      */   }
/*      */   
/*      */   public static void assertSame(Object paramObject1, Object paramObject2, String paramString) {
/*  456 */     if (paramObject2 == paramObject1)
/*      */       return; 
/*  459 */     failNotSame(paramObject1, paramObject2, paramString);
/*      */   }
/*      */   
/*      */   public static void assertSame(Object paramObject1, Object paramObject2) {
/*  469 */     assertSame(paramObject1, paramObject2, null);
/*      */   }
/*      */   
/*      */   public static void assertNotSame(Object paramObject1, Object paramObject2, String paramString) {
/*  480 */     if (paramObject2 == paramObject1)
/*  481 */       failSame(paramObject1, paramObject2, paramString); 
/*      */   }
/*      */   
/*      */   public static void assertNotSame(Object paramObject1, Object paramObject2) {
/*  492 */     assertNotSame(paramObject1, paramObject2, null);
/*      */   }
/*      */   
/*      */   private static void failSame(Object paramObject1, Object paramObject2, String paramString) {
/*  496 */     String str = "";
/*  497 */     if (paramString != null)
/*  498 */       str = paramString + " "; 
/*  500 */     fail(str + EclipseInterface.ASSERT_LEFT2 + paramObject2 + EclipseInterface.ASSERT_MIDDLE + paramObject1 + EclipseInterface.ASSERT_RIGHT);
/*      */   }
/*      */   
/*      */   private static void failNotSame(Object paramObject1, Object paramObject2, String paramString) {
/*  504 */     String str = "";
/*  505 */     if (paramString != null)
/*  506 */       str = paramString + " "; 
/*  508 */     fail(str + EclipseInterface.ASSERT_LEFT + paramObject2 + EclipseInterface.ASSERT_MIDDLE + paramObject1 + EclipseInterface.ASSERT_RIGHT);
/*      */   }
/*      */   
/*      */   private static void failNotEquals(Object paramObject1, Object paramObject2, String paramString) {
/*  512 */     fail(format(paramObject1, paramObject2, paramString));
/*      */   }
/*      */   
/*      */   static String format(Object paramObject1, Object paramObject2, String paramString) {
/*  516 */     String str = "";
/*  517 */     if (null != paramString)
/*  518 */       str = paramString + " "; 
/*  521 */     return str + EclipseInterface.ASSERT_LEFT + paramObject2 + EclipseInterface.ASSERT_MIDDLE + paramObject1 + EclipseInterface.ASSERT_RIGHT;
/*      */   }
/*      */   
/*      */   public static void assertEquals(Collection<?> paramCollection1, Collection<?> paramCollection2) {
/*  532 */     assertEquals(paramCollection1, paramCollection2, (String)null);
/*      */   }
/*      */   
/*      */   public static void assertEquals(Collection<?> paramCollection1, Collection<?> paramCollection2, String paramString) {
/*  543 */     if (paramCollection1 == paramCollection2)
/*      */       return; 
/*  547 */     if (paramCollection1 == null || paramCollection2 == null)
/*  548 */       if (paramString != null) {
/*  549 */         fail(paramString);
/*      */       } else {
/*  551 */         fail("Collections not equal: expected: " + paramCollection2 + " and actual: " + paramCollection1);
/*      */       }  
/*  555 */     assertEquals(paramCollection1.size(), paramCollection2.size(), ((paramString == null) ? "" : (paramString + ": ")) + "lists don't have the same size");
/*  557 */     Iterator<?> iterator1 = paramCollection1.iterator();
/*  558 */     Iterator<?> iterator2 = paramCollection2.iterator();
/*  559 */     byte b = -1;
/*  560 */     while (iterator1.hasNext() && iterator2.hasNext()) {
/*  561 */       b++;
/*  562 */       Object object1 = iterator2.next();
/*  563 */       Object object2 = iterator1.next();
/*  564 */       String str1 = "Lists differ at element [" + b + "]: " + object1 + " != " + object2;
/*  565 */       String str2 = (paramString == null) ? str1 : (paramString + ": " + str1);
/*  567 */       assertEqualsImpl(object2, object1, str2);
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void assertEquals(Iterator<?> paramIterator1, Iterator<?> paramIterator2) {
/*  578 */     assertEquals(paramIterator1, paramIterator2, (String)null);
/*      */   }
/*      */   
/*      */   public static void assertEquals(Iterator<?> paramIterator1, Iterator<?> paramIterator2, String paramString) {
/*  589 */     if (paramIterator1 == paramIterator2)
/*      */       return; 
/*  593 */     if (paramIterator1 == null || paramIterator2 == null)
/*  594 */       if (paramString != null) {
/*  595 */         fail(paramString);
/*      */       } else {
/*  597 */         fail("Iterators not equal: expected: " + paramIterator2 + " and actual: " + paramIterator1);
/*      */       }  
/*  601 */     byte b = -1;
/*  602 */     while (paramIterator1.hasNext() && paramIterator2.hasNext()) {
/*  604 */       b++;
/*  605 */       Object object1 = paramIterator2.next();
/*  606 */       Object object2 = paramIterator1.next();
/*  607 */       String str1 = "Iterators differ at element [" + b + "]: " + object1 + " != " + object2;
/*  608 */       String str2 = (paramString == null) ? str1 : (paramString + ": " + str1);
/*  610 */       assertEqualsImpl(object2, object1, str2);
/*      */     } 
/*  614 */     if (paramIterator1.hasNext()) {
/*  616 */       String str1 = "Actual iterator returned more elements than the expected iterator.";
/*  617 */       String str2 = (paramString == null) ? str1 : (paramString + ": " + str1);
/*  618 */       fail(str2);
/*  620 */     } else if (paramIterator2.hasNext()) {
/*  622 */       String str1 = "Expected iterator returned more elements than the actual iterator.";
/*  623 */       String str2 = (paramString == null) ? str1 : (paramString + ": " + str1);
/*  624 */       fail(str2);
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void assertEquals(Iterable<?> paramIterable1, Iterable<?> paramIterable2) {
/*  636 */     assertEquals(paramIterable1, paramIterable2, (String)null);
/*      */   }
/*      */   
/*      */   public static void assertEquals(Iterable<?> paramIterable1, Iterable<?> paramIterable2, String paramString) {
/*  646 */     if (paramIterable1 == paramIterable2)
/*      */       return; 
/*  650 */     if (paramIterable1 == null || paramIterable2 == null)
/*  651 */       if (paramString != null) {
/*  652 */         fail(paramString);
/*      */       } else {
/*  654 */         fail("Iterables not equal: expected: " + paramIterable2 + " and actual: " + paramIterable1);
/*      */       }  
/*  658 */     Iterator<?> iterator1 = paramIterable1.iterator();
/*  659 */     Iterator<?> iterator2 = paramIterable2.iterator();
/*  661 */     assertEquals(iterator1, iterator2, paramString);
/*      */   }
/*      */   
/*      */   public static void assertEquals(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, String paramString) {
/*  675 */     if (paramArrayOfObject1 == paramArrayOfObject2)
/*      */       return; 
/*  679 */     if ((paramArrayOfObject1 == null && paramArrayOfObject2 != null) || (paramArrayOfObject1 != null && paramArrayOfObject2 == null))
/*  680 */       if (paramString != null) {
/*  681 */         fail(paramString);
/*      */       } else {
/*  683 */         fail("Arrays not equal: " + Arrays.toString(paramArrayOfObject2) + " and " + Arrays.toString(paramArrayOfObject1));
/*      */       }  
/*  686 */     assertEquals(Arrays.asList(paramArrayOfObject1), Arrays.asList(paramArrayOfObject2), paramString);
/*      */   }
/*      */   
/*      */   public static void assertEqualsNoOrder(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, String paramString) {
/*  697 */     if (paramArrayOfObject1 == paramArrayOfObject2)
/*      */       return; 
/*  701 */     if ((paramArrayOfObject1 == null && paramArrayOfObject2 != null) || (paramArrayOfObject1 != null && paramArrayOfObject2 == null))
/*  702 */       failAssertNoEqual("Arrays not equal: " + 
/*  703 */           Arrays.toString(paramArrayOfObject2) + " and " + Arrays.toString(paramArrayOfObject1), paramString); 
/*  707 */     if (paramArrayOfObject1.length != paramArrayOfObject2.length)
/*  708 */       failAssertNoEqual("Arrays do not have the same size:" + paramArrayOfObject1.length + " != " + paramArrayOfObject2.length, paramString); 
/*  713 */     List<Object> list = Lists.newArrayList();
/*  714 */     for (Object object : paramArrayOfObject1)
/*  715 */       list.add(object); 
/*  717 */     for (Object object : paramArrayOfObject2)
/*  718 */       list.remove(object); 
/*  720 */     if (list.size() != 0)
/*  721 */       failAssertNoEqual("Arrays not equal: " + 
/*  722 */           Arrays.toString(paramArrayOfObject2) + " and " + Arrays.toString(paramArrayOfObject1), paramString); 
/*      */   }
/*      */   
/*      */   private static void failAssertNoEqual(String paramString1, String paramString2) {
/*  728 */     if (paramString2 != null) {
/*  729 */       fail(paramString2);
/*      */     } else {
/*  731 */       fail(paramString1);
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void assertEquals(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2) {
/*  743 */     assertEquals(paramArrayOfObject1, paramArrayOfObject2, (String)null);
/*      */   }
/*      */   
/*      */   public static void assertEqualsNoOrder(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2) {
/*  753 */     assertEqualsNoOrder(paramArrayOfObject1, paramArrayOfObject2, null);
/*      */   }
/*      */   
/*      */   public static void assertEquals(Set<?> paramSet1, Set<?> paramSet2) {
/*  760 */     assertEquals(paramSet1, paramSet2, (String)null);
/*      */   }
/*      */   
/*      */   public static void assertEquals(Set<?> paramSet1, Set<?> paramSet2, String paramString) {
/*  767 */     if (paramSet1 == paramSet2)
/*      */       return; 
/*  771 */     if (paramSet1 == null || paramSet2 == null)
/*  773 */       if (paramString == null) {
/*  774 */         fail("Sets not equal: expected: " + paramSet2 + " and actual: " + paramSet1);
/*      */       } else {
/*  776 */         failNotEquals(paramSet1, paramSet2, paramString);
/*      */       }  
/*  780 */     if (!paramSet1.equals(paramSet2))
/*  781 */       if (paramString == null) {
/*  782 */         fail("Sets differ: expected " + paramSet2 + " but got " + paramSet1);
/*      */       } else {
/*  784 */         failNotEquals(paramSet1, paramSet2, paramString);
/*      */       }  
/*      */   }
/*      */   
/*      */   public static void assertEqualsDeep(Set<?> paramSet1, Set<?> paramSet2, String paramString) {
/*  790 */     if (paramSet1 == paramSet2)
/*      */       return; 
/*  794 */     if (paramSet1 == null || paramSet2 == null)
/*  796 */       if (paramString == null) {
/*  797 */         fail("Sets not equal: expected: " + paramSet2 + " and actual: " + paramSet1);
/*      */       } else {
/*  799 */         failNotEquals(paramSet1, paramSet2, paramString);
/*      */       }  
/*  803 */     Iterator<?> iterator1 = paramSet1.iterator();
/*  804 */     Iterator<?> iterator2 = paramSet2.iterator();
/*  805 */     while (iterator2.hasNext()) {
/*  806 */       Object object1 = iterator2.next();
/*  807 */       if (!iterator1.hasNext())
/*  808 */         fail("Sets not equal: expected: " + paramSet2 + " and actual: " + paramSet1); 
/*  810 */       Object object2 = iterator1.next();
/*  811 */       if (object1.getClass().isArray()) {
/*  812 */         assertArrayEquals(object2, object1, paramString);
/*      */         continue;
/*      */       } 
/*  814 */       assertEqualsImpl(object2, object1, paramString);
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void assertEquals(Map<?, ?> paramMap1, Map<?, ?> paramMap2, String paramString) {
/*  823 */     if (paramMap1 == paramMap2)
/*      */       return; 
/*  827 */     if (paramMap1 == null || paramMap2 == null)
/*  828 */       fail("Maps not equal: expected: " + paramMap2 + " and actual: " + paramMap1); 
/*  831 */     if (paramMap1.size() != paramMap2.size())
/*  832 */       fail("Maps do not have the same size:" + paramMap1.size() + " != " + paramMap2.size()); 
/*  835 */     Set<Map.Entry<?, ?>> set = paramMap1.entrySet();
/*  836 */     for (Map.Entry<?, ?> entry : set) {
/*  837 */       Map.Entry entry1 = entry;
/*  838 */       Object object1 = entry1.getKey();
/*  839 */       Object object2 = entry1.getValue();
/*  840 */       Object object3 = paramMap2.get(object1);
/*  841 */       String str = (paramString != null) ? paramString : ("Maps do not match for key:" + object1 + " actual:" + object2 + " expected:" + object3);
/*  843 */       assertEqualsImpl(object2, object3, str);
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void assertEqualsDeep(Map<?, ?> paramMap1, Map<?, ?> paramMap2) {
/*  849 */     assertEqualsDeep(paramMap1, paramMap2, (String)null);
/*      */   }
/*      */   
/*      */   public static void assertEqualsDeep(Map<?, ?> paramMap1, Map<?, ?> paramMap2, String paramString) {
/*  854 */     if (paramMap1 == paramMap2)
/*      */       return; 
/*  858 */     if (paramMap1 == null || paramMap2 == null)
/*  859 */       fail("Maps not equal: expected: " + paramMap2 + " and actual: " + paramMap1); 
/*  862 */     if (paramMap1.size() != paramMap2.size())
/*  863 */       fail("Maps do not have the same size:" + paramMap1.size() + " != " + paramMap2.size()); 
/*  866 */     Set<Map.Entry<?, ?>> set = paramMap1.entrySet();
/*  867 */     for (Map.Entry<?, ?> entry : set) {
/*  868 */       Map.Entry entry1 = entry;
/*  869 */       Object object1 = entry1.getKey();
/*  870 */       Object object2 = entry1.getValue();
/*  871 */       Object object3 = paramMap2.get(object1);
/*  872 */       String str = (paramString != null) ? paramString : ("Maps do not match for key:" + object1 + " actual:" + object2 + " expected:" + object3);
/*  874 */       if (object3.getClass().isArray()) {
/*  875 */         assertArrayEquals(object2, object3, str);
/*      */         continue;
/*      */       } 
/*  877 */       assertEqualsImpl(object2, object3, str);
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void assertNotEquals(Object paramObject1, Object paramObject2, String paramString) {
/*      */     boolean bool;
/*      */     try {
/*  890 */       assertEquals(paramObject1, paramObject2);
/*  891 */       bool = true;
/*  892 */     } catch (AssertionError assertionError) {
/*  893 */       bool = false;
/*      */     } 
/*  896 */     if (bool)
/*  897 */       fail(paramString); 
/*      */   }
/*      */   
/*      */   public static void assertNotEquals(Object paramObject1, Object paramObject2) {
/*  902 */     assertNotEquals(paramObject1, paramObject2, (String)null);
/*      */   }
/*      */   
/*      */   static void assertNotEquals(String paramString1, String paramString2, String paramString3) {
/*  906 */     assertNotEquals(paramString1, paramString2, paramString3);
/*      */   }
/*      */   
/*      */   static void assertNotEquals(String paramString1, String paramString2) {
/*  910 */     assertNotEquals(paramString1, paramString2, (String)null);
/*      */   }
/*      */   
/*      */   static void assertNotEquals(long paramLong1, long paramLong2, String paramString) {
/*  914 */     assertNotEquals(Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString);
/*      */   }
/*      */   
/*      */   static void assertNotEquals(long paramLong1, long paramLong2) {
/*  918 */     assertNotEquals(paramLong1, paramLong2, (String)null);
/*      */   }
/*      */   
/*      */   static void assertNotEquals(boolean paramBoolean1, boolean paramBoolean2, String paramString) {
/*  922 */     assertNotEquals(Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString);
/*      */   }
/*      */   
/*      */   static void assertNotEquals(boolean paramBoolean1, boolean paramBoolean2) {
/*  926 */     assertNotEquals(paramBoolean1, paramBoolean2, (String)null);
/*      */   }
/*      */   
/*      */   static void assertNotEquals(byte paramByte1, byte paramByte2, String paramString) {
/*  930 */     assertNotEquals(Byte.valueOf(paramByte1), Byte.valueOf(paramByte2), paramString);
/*      */   }
/*      */   
/*      */   static void assertNotEquals(byte paramByte1, byte paramByte2) {
/*  934 */     assertNotEquals(paramByte1, paramByte2, (String)null);
/*      */   }
/*      */   
/*      */   static void assertNotEquals(char paramChar1, char paramChar2, String paramString) {
/*  938 */     assertNotEquals(Character.valueOf(paramChar1), Character.valueOf(paramChar2), paramString);
/*      */   }
/*      */   
/*      */   static void assertNotEquals(char paramChar1, char paramChar2) {
/*  942 */     assertNotEquals(paramChar1, paramChar2, (String)null);
/*      */   }
/*      */   
/*      */   static void assertNotEquals(short paramShort1, short paramShort2, String paramString) {
/*  946 */     assertNotEquals(Short.valueOf(paramShort1), Short.valueOf(paramShort2), paramString);
/*      */   }
/*      */   
/*      */   static void assertNotEquals(short paramShort1, short paramShort2) {
/*  950 */     assertNotEquals(paramShort1, paramShort2, (String)null);
/*      */   }
/*      */   
/*      */   static void assertNotEquals(int paramInt1, int paramInt2, String paramString) {
/*  954 */     assertNotEquals(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString);
/*      */   }
/*      */   
/*      */   static void assertNotEquals(int paramInt1, int paramInt2) {
/*  958 */     assertNotEquals(paramInt1, paramInt2, (String)null);
/*      */   }
/*      */   
/*      */   public static void assertNotEquals(float paramFloat1, float paramFloat2, float paramFloat3, String paramString) {
/*      */     boolean bool;
/*      */     try {
/*  964 */       assertEquals(paramFloat1, paramFloat2, paramFloat3, paramString);
/*  965 */       bool = true;
/*  966 */     } catch (AssertionError assertionError) {
/*  967 */       bool = false;
/*      */     } 
/*  970 */     if (bool)
/*  971 */       fail(paramString); 
/*      */   }
/*      */   
/*      */   public static void assertNotEquals(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  976 */     assertNotEquals(paramFloat1, paramFloat2, paramFloat3, (String)null);
/*      */   }
/*      */   
/*      */   public static void assertNotEquals(double paramDouble1, double paramDouble2, double paramDouble3, String paramString) {
/*      */     boolean bool;
/*      */     try {
/*  982 */       assertEquals(paramDouble1, paramDouble2, paramDouble3, paramString);
/*  983 */       bool = true;
/*  984 */     } catch (AssertionError assertionError) {
/*  985 */       bool = false;
/*      */     } 
/*  988 */     if (bool)
/*  989 */       fail(paramString); 
/*      */   }
/*      */   
/*      */   public static void assertNotEquals(Set<?> paramSet1, Set<?> paramSet2) {
/*  994 */     assertNotEquals(paramSet1, paramSet2, (String)null);
/*      */   }
/*      */   
/*      */   public static void assertNotEquals(Set<?> paramSet1, Set<?> paramSet2, String paramString) {
/*      */     boolean bool;
/*      */     try {
/* 1000 */       assertEquals(paramSet1, paramSet2, paramString);
/* 1001 */       bool = true;
/* 1002 */     } catch (AssertionError assertionError) {
/* 1003 */       bool = false;
/*      */     } 
/* 1006 */     if (bool)
/* 1007 */       fail(paramString); 
/*      */   }
/*      */   
/*      */   public static void assertNotEqualsDeep(Set<?> paramSet1, Set<?> paramSet2) {
/* 1012 */     assertNotEqualsDeep(paramSet1, paramSet2, (String)null);
/*      */   }
/*      */   
/*      */   public static void assertNotEqualsDeep(Set<?> paramSet1, Set<?> paramSet2, String paramString) {
/*      */     boolean bool;
/*      */     try {
/* 1018 */       assertEqualsDeep(paramSet1, paramSet2, paramString);
/* 1019 */       bool = true;
/* 1020 */     } catch (AssertionError assertionError) {
/* 1021 */       bool = false;
/*      */     } 
/* 1024 */     if (bool)
/* 1025 */       fail(paramString); 
/*      */   }
/*      */   
/*      */   public static void assertNotEquals(Map<?, ?> paramMap1, Map<?, ?> paramMap2) {
/* 1030 */     assertNotEquals(paramMap1, paramMap2, (String)null);
/*      */   }
/*      */   
/*      */   public static void assertNotEquals(Map<?, ?> paramMap1, Map<?, ?> paramMap2, String paramString) {
/*      */     boolean bool;
/*      */     try {
/* 1036 */       assertEquals(paramMap1, paramMap2, paramString);
/* 1037 */       bool = true;
/* 1038 */     } catch (AssertionError assertionError) {
/* 1039 */       bool = false;
/*      */     } 
/* 1042 */     if (bool)
/* 1043 */       fail(paramString); 
/*      */   }
/*      */   
/*      */   public static void assertNotEqualsDeep(Map<?, ?> paramMap1, Map<?, ?> paramMap2) {
/* 1048 */     assertNotEqualsDeep(paramMap1, paramMap2, (String)null);
/*      */   }
/*      */   
/*      */   public static void assertNotEqualsDeep(Map<?, ?> paramMap1, Map<?, ?> paramMap2, String paramString) {
/*      */     boolean bool;
/*      */     try {
/* 1054 */       assertEqualsDeep(paramMap1, paramMap2, paramString);
/* 1055 */       bool = true;
/* 1056 */     } catch (AssertionError assertionError) {
/* 1057 */       bool = false;
/*      */     } 
/* 1060 */     if (bool)
/* 1061 */       fail(paramString); 
/*      */   }
/*      */   
/*      */   public static void assertNotEquals(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 1066 */     assertNotEquals(paramDouble1, paramDouble2, paramDouble3, (String)null);
/*      */   }
/*      */   
/*      */   public static void assertThrows(ThrowingRunnable paramThrowingRunnable) {
/* 1088 */     assertThrows(Throwable.class, paramThrowingRunnable);
/*      */   }
/*      */   
/*      */   public static <T extends Throwable> void assertThrows(Class<T> paramClass, ThrowingRunnable paramThrowingRunnable) {
/* 1104 */     expectThrows(paramClass, paramThrowingRunnable);
/*      */   }
/*      */   
/*      */   public static <T extends Throwable> T expectThrows(Class<T> paramClass, ThrowingRunnable paramThrowingRunnable) {
/*      */     try {
/* 1121 */       paramThrowingRunnable.run();
/* 1122 */     } catch (Throwable throwable) {
/* 1123 */       if (paramClass.isInstance(throwable))
/* 1124 */         return paramClass.cast(throwable); 
/* 1126 */       String str1 = String.format("Expected %s to be thrown, but %s was thrown", new Object[] { paramClass
/* 1127 */             .getSimpleName(), throwable.getClass().getSimpleName() });
/* 1129 */       throw new AssertionError(str1, throwable);
/*      */     } 
/* 1132 */     String str = String.format("Expected %s to be thrown, but nothing was thrown", new Object[] { paramClass
/* 1133 */           .getSimpleName() });
/* 1134 */     throw new AssertionError(str);
/*      */   }
/*      */   
/*      */   public static interface ThrowingRunnable {
/*      */     void run() throws Throwable;
/*      */   }
/*      */ }


/* Location:              C:\Users\wangsoon\Downloads\jar_files\testng-6.11.jar!\org\testng\Assert.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */
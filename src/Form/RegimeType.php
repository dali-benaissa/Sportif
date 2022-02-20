<?php

namespace App\Form;

use App\Entity\Regime;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class RegimeType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('Aliments_autorises')
            ->add('Aliments_interdits')
            ->add('petit_dejeuner')
            ->add('collation1')
            ->add('dejeuner')
            ->add('collation2')
            ->add('diner')
            ->add('conseils')
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Regime::class,
        ]);
    }
}
